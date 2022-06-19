package com.demo.justworktimer.ui.basecomponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.justworktimer.persistance.entity.SetAction
import com.demo.justworktimer.persistance.entity.WorkoutSet
import com.demo.justworktimer.feature.set.components.SetItemComponent

@Composable
fun BaseCard(
    modifier: Modifier = Modifier,
    content: @Composable  () -> Unit) {
    Surface(shadowElevation = 4.dp,
        tonalElevation = 6.dp ,
        //shape = MaterialTheme.shapes.large,
        modifier = modifier) {
        content.invoke()
    }
}

@Composable
fun BaseText(modifier: Modifier = Modifier, title : String){
    Text(text = title,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSecondaryContainer)
}

@Composable
fun BaseTextFieldInput(modifier: Modifier = Modifier,
                       labelTitle: String,
                       text : TextFieldValue,
                       keyboardOptions : KeyboardOptions = KeyboardOptions.Default,
                       onValueChanged : (TextFieldValue) -> Unit = {}){
            TextField(modifier = modifier,
                value = text,
            textStyle = MaterialTheme.typography.labelMedium.copy(textAlign = TextAlign.Center),
            shape = MaterialTheme.shapes.medium,
            keyboardOptions = keyboardOptions,
            label = {
                Text(
                    text = labelTitle,
                    modifier = Modifier,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer)
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor =  MaterialTheme.colorScheme.onSecondaryContainer,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                onValueChanged.invoke(it)
            })
}

@Preview(name = "BaseComponents")
@Composable
private fun PreviewBaseComponents() {
    val setList = listOf(
        WorkoutSet(setId = 1, name = "Tabata", actions = listOf(SetAction(1, "Rest", 5000)), rounds = 3),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8)
    )
    SetItemComponent(setList[0],
        {  },
        {  })
}

@Preview(name = "BaseComponents")
@Composable
private fun PreviewBaseText() {
    Text(text = "titlee",
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onSecondaryContainer)
}

/*
@SuppressLint("UnrememberedMutableState")
@Composable
@Preview
private fun CreateSetScreenPreview() {
    Column(modifier= Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primaryContainer)
        .fillMaxSize()
        .padding(10.dp)
    ) {
        Column{
            BaseTextFieldInput(modifier = Modifier
                .weight(5f, fill = false)
                .shadow(shape = RoundedCornerShape(4.dp), elevation = 1.dp),
                labelTitle = "Set Name",
                text = mutableStateOf("setName"),
            ){
                //Handle Value Change
            }
            BaseTextFieldInput(modifier = Modifier
                .weight(6f, fill = false)
                .shadow(shape = RoundedCornerShape(4.dp), elevation = 1.dp),
                labelTitle = "Rounds",
                text = mutableStateOf("rounds.value")
            ){
                //Handle Value Change
            }
        }
    }
}*/
