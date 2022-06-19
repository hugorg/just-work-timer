package com.demo.justworktimer.feature.createaction

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.justworktimer.persistance.entity.SetAction
import com.demo.justworktimer.ui.basecomponents.BaseCard
import com.demo.justworktimer.ui.basecomponents.BaseTextFieldInput
import com.demo.justworktimer.ui.theme.LocalDimensions
import java.util.concurrent.TimeUnit

@Composable
fun CreateActionCard(
    onActionCreated: (SetAction)-> Unit
) {
    val maxChar = 2
    var seconds by remember { mutableStateOf(TextFieldValue()) }
    var minutes by remember {  mutableStateOf(TextFieldValue()) }
    var actionName by remember { mutableStateOf(TextFieldValue()) }
    val focusManager = LocalFocusManager.current

    BaseCard(modifier = Modifier
        .padding(6.dp)
        .background(color = Color.Transparent)
        .border(width = 1.dp, color = Color.Transparent)
        .padding(2.dp)
        .shadow(4.dp, shape = MaterialTheme.shapes.medium)) {
        Column(modifier = Modifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(LocalDimensions.current.medium)
                    .height(LocalDimensions.current.bar)
            ) {
                BaseTextFieldInput(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(7f)
                        .border(width = 1.dp, color = Color.Transparent)
                        .padding(2.dp)
                        .shadow(4.dp, shape = MaterialTheme.shapes.medium),
                    labelTitle = "Action Name",
                    text = actionName,
                    onValueChanged = {
                        actionName = it
                    })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(LocalDimensions.current.medium)
                    .height(LocalDimensions.current.bar)
            ){
                BaseTextFieldInput(
                    modifier = Modifier
                        .weight(3f)
                        .border(width = 1.dp, color = Color.Transparent)
                        .padding(2.dp)
                        .shadow(4.dp, shape = MaterialTheme.shapes.medium),
                    labelTitle = "Minutes",
                    text = minutes,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    onValueChanged = { textFieldValue ->
                        val text = textFieldValue.text.take(maxChar)
                        // This line will take (in case the user try to paste a text from the clipboard) only the allowed amount of characters
                        minutes = textFieldValue.copy(text = text)
                        if (text.length > maxChar){
                            focusManager.moveFocus(FocusDirection.Down) // Or receive a lambda function
                        }
                    }
                )
                BaseTextFieldInput(
                    modifier = Modifier
                        .weight(3f)
                        .border(width = 1.dp, color = Color.Transparent)
                        .padding(2.dp)
                        .shadow(4.dp, shape = MaterialTheme.shapes.medium),
                    labelTitle = "Seconds",
                    text = seconds,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword),
                    onValueChanged = { textFieldValue ->
                        var text = textFieldValue.text.take(maxChar)
                        // This line will take (in case the user try to paste a text from the clipboard) only the allowed amount of characters
                        if (text.length == maxChar){
                            if(text.toCharArray()[0].digitToInt() > 6){
                                text = "6${text.toCharArray()[1]}"
                                if(text.toCharArray()[1].digitToInt() > 0)
                                    text = "60"
                            }
                            focusManager.moveFocus(FocusDirection.Left) // Or receive a lambda function
                        }
                        seconds = textFieldValue.copy(text = text)
                    }
                )
                Button(onClick = {
                    if(actionName.text.isEmpty())
                        return@Button
                    val setAction = SetAction(
                        actionName = actionName.text,
                        duration = parseDuration(minutes.text.toInt(), seconds.text.toInt())
                    )
                    onActionCreated.invoke(setAction)
                },
                    modifier = Modifier
                        .width(LocalDimensions.current.bar)
                        .height(LocalDimensions.current.bar)
                        .align(Alignment.CenterVertically)
                        .border(width = 4.dp, color = Color.Transparent, shape = CircleShape)
                        .padding(4.dp),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 4.dp,
                        pressedElevation = 2.dp
                    )
                ) {
                    Text(text = "+", fontSize = 24.sp, textAlign = TextAlign.Center)
                }
            }

        }
    }
}

fun parseDuration(minutes: Int, seconds: Int): Int {
    val timeMinutes = TimeUnit.MINUTES.toMillis(minutes.toLong())
    val timeSeconds = TimeUnit.SECONDS.toMillis(seconds.toLong())
    return (timeMinutes +timeSeconds).toInt()
}



@Composable
@Preview
private fun CreateactionScreenPreview() {
    CreateActionCard {

    }
}

