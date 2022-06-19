package com.demo.justworktimer.feature.createset

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.justworktimer.feature.createaction.ActionItemList
import com.demo.justworktimer.feature.createaction.CreateActionCard
import com.demo.justworktimer.feature.set.components.SetItemList
import com.demo.justworktimer.ui.basecomponents.BaseText
import com.demo.justworktimer.ui.basecomponents.BaseTextFieldInput
import com.demo.justworktimer.ui.theme.LocalDimensions

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSetScreen(
    state: CreateSetState = CreateSetState(),
    actions: CreateSetActions = LocalCreateSetActions.current
)  {

    var setName by remember { state.setName }
    var rounds by remember { state.rounds}
    var setActions = remember { state.setActions }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            Button(onClick = {

            }, shape = CircleShape){
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "fab icon")
            } },
    ) { padding ->
        Column(modifier = Modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(padding)
            .fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(LocalDimensions.current.bar),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Create new set",
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                )
            }

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
                    labelTitle = "Set Name",
                    text = setName,
                    onValueChanged = {
                        setName = it
                    })
                BaseTextFieldInput(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2.6f)
                        .border(width = 1.dp, color = Color.Transparent)
                        .padding(2.dp)
                        .shadow(4.dp, shape = MaterialTheme.shapes.medium),
                    labelTitle = "Rounds",
                    text = rounds,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword),
                    onValueChanged = {
                        rounds = it
                    })

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(LocalDimensions.current.medium),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Actions",
                    modifier = Modifier.wrapContentSize(align = Alignment.Center),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer)
            }
            CreateActionCard {
                setActions.add(it)
            }
            ActionItemList(items = setActions){
                setActions.remove(it)
                }
            }
        }
        //AddAction

           /**/
    }

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview
private fun CreateSetScreenPreview() {
    CreateSetScreen()
}

