@file:OptIn(ExperimentalMaterial3Api::class)

package com.demo.justworktimer.ui.sets

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentWithReceiverOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.justworktimer.data.entity.SetAction
import com.demo.justworktimer.data.entity.WorkoutSet
import com.demo.justworktimer.ui.navigation.Navigator
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SetScreen(navigator : Navigator) {
    val set = WorkoutSet(1,
        "Tabata",
        actions = listOf(SetAction(1, "Rest", 5000))
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            Button(onClick = {}){
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "fab icon")
        } },
    ) {
        SetItemList(listOf(set))
    }
}

/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true,
    device = Devices.PIXEL_3A)
@Composable
fun SetScreenPreview(){
    Scaffold(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "fab icon")
            }
       }
    ) {
        val set = WorkoutSet(1,
            "Tabata",
            actions = listOf(SetAction(1, "Rest", 5000))
        )
        SetItemList(listOf(set))
    }
}*/
