package com.demo.justworktimer.feature.createset

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.justworktimer.ui.basecomponents.BaseTextFieldInput

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSetScreen(
    state: CreateSetState = CreateSetState(),
    actions: CreateSetActions = LocalCreateSetActions.current
)  {

    val setName = remember { state.setName }
    val rounds = remember { state.rounds }
    val setActions = remember { state.setActions }
    val shouldShowNewAction = remember { mutableStateOf(false)}

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            Button(onClick = {

            }){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "fab icon")
            } },
    ) { padding ->
        Column(modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()) {
            LazyVerticalGrid(modifier = Modifier
                .padding(padding)
                .background(color = MaterialTheme.colorScheme.primaryContainer),
                columns = GridCells.Fixed(2)){
                items(2) { index ->
                    when(index){
                        0-> {
                            BaseTextFieldInput(
                                modifier = Modifier.background(Color.Transparent),
                                labelTitle = "Set Name",
                                text = setName,
                                onValueChanged = {
                                    setName.value = it
                                })
                        }
                        1->{
                            BaseTextFieldInput(
                                modifier = Modifier.background(Color.Transparent),
                                labelTitle = "Rounds",
                                text = rounds,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                onValueChanged = {
                                    rounds.value = it
                                })
                        }
                    }
                }
            }
            //AddAction
            Row(modifier = Modifier.fillMaxWidth()) {
                BaseTextFieldInput(
                    modifier = Modifier.weight(3f),
                    labelTitle = "Add Action",
                    text = mutableStateOf("actionName"),
                    onValueChanged = {
                    }
                )
                BaseTextFieldInput(
                    modifier = Modifier.weight(3f),
                    labelTitle = "Seconds",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    ),
                    text = mutableStateOf("actionName"),
                    onValueChanged = {
                    }
                )
                Icon(imageVector = Icons.Sharp.Add,
                    contentDescription = "AddContent",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .align(CenterVertically)
                        .background(color = MaterialTheme.colorScheme.primary))

            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview
private fun CreateSetScreenPreview() {
    CreateSetScreen()
}

