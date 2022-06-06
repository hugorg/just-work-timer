package com.demo.justworktimer.feature.createset.components

import android.annotation.SuppressLint
import android.widget.NumberPicker
import androidx.compose.foundation.background
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.demo.justworktimer.ui.basecomponents.BaseTextFieldInput




@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun TextFieldInputPreview(){
    BaseTextFieldInput(labelTitle = "Rounds",
        text = mutableStateOf("1"),
        modifier = Modifier.background(Color.Blue),
        onValueChanged = {})
}