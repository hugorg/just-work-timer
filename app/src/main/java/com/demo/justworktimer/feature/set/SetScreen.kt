package com.demo.justworktimer.feature.set

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.justworktimer.data.entity.SetAction
import com.demo.justworktimer.data.entity.WorkoutSet
import com.demo.justworktimer.feature.set.components.SetItemList
import java.util.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetScreen(
    state: SetState = SetState(),
    actions: SetActions = LocalSetActions.current
) {
    val setList = Arrays.asList(WorkoutSet(setId = 1, name = "Tabata", actions = listOf(SetAction(1, "Rest", 5000)), rounds = 3),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8))

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            Button(onClick = {
                actions.onNewSetClicked.invoke()
            }){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "fab icon")
            } },
    ) {
        SetItemList(setList, actions.onPlaySetClicked, actions.onEditSetClicked)
    }
}

@Composable
@Preview
private fun SetScreenPreview() {
    SetScreen()
}

