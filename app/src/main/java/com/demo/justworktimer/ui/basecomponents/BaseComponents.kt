package com.demo.justworktimer.ui.basecomponents

import android.annotation.SuppressLint
import android.view.textclassifier.TextSelection
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.justworktimer.data.entity.SetAction
import com.demo.justworktimer.data.entity.WorkoutSet
import com.demo.justworktimer.feature.set.components.SetItemComponent
import java.util.*

@Composable
fun BaseCard(
    modifier: Modifier = Modifier,
    content: @Composable  () -> Unit) {
    Surface(shadowElevation = 4.dp,
        tonalElevation = 6.dp ,
        shape = MaterialTheme.shapes.large,
        modifier = modifier) {
        content.invoke()
    }
}

@Composable
fun BaseText(modifier: Modifier = Modifier, title : String){
    Text(text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSecondaryContainer)
}

@Composable
fun BaseTextFieldInput(modifier: Modifier,
                       labelTitle: String,
                       text : MutableState<String>,
                       keyboardOptions : KeyboardOptions = KeyboardOptions.Default,
                       onValueChanged : (String) -> Unit){
            TextField(modifier = modifier,
                value = TextFieldValue(
                text = text.value,
                composition = TextRange(0, 3)
            ),
            keyboardOptions = keyboardOptions,
            label = {
                BaseText(title = labelTitle)
            },
            onValueChange = {
                onValueChanged.invoke(it.text)
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
}