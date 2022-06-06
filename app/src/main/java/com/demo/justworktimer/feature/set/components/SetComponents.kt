package com.demo.justworktimer.feature.set.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.justworktimer.data.entity.SetAction
import com.demo.justworktimer.data.entity.WorkoutSet
import com.demo.justworktimer.ui.basecomponents.BaseCard
import com.demo.justworktimer.ui.basecomponents.BaseText
import java.util.*

@Composable
fun SetItemComponent(
    set: WorkoutSet,
    onPlaySetClicked: (Int) -> Unit,
    onEditSetClicked: (Int) -> Unit
) {
    BaseCard{
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)){
            val duration = set.actions.stream().map { action-> action.duration }
                .reduce { count, accumulate -> count + accumulate }.get().toString()
            Column(Modifier.fillMaxWidth()){
                Row {
                    Column(Modifier.weight(7f)) {
                        BaseText(title = set.name)
                        BaseText(title = "Elapsed time: $duration ms")
                    }
                    Row(
                        Modifier
                            .weight(3f)
                            .padding(6.dp)
                            .fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        IconButton(
                            onClick = { onPlaySetClicked.invoke(set.setId) },
                        ){
                            Icon(
                                Icons.Filled.PlayArrow,
                                contentDescription = "Localized description",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }
                        IconButton(
                            onClick = { },
                        ){
                            Icon(
                                Icons.Filled.Edit,
                                contentDescription = "Localized description",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SetItemList(
    items: List<WorkoutSet>,
    onPlaySetClicked: (Int) -> Unit,
    onEditSetClicked: (Int) -> Unit
){
    LazyColumn(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(10.dp)
    ){
        items(items) { set ->
            SetItemComponent(set,
                onPlaySetClicked,
                onEditSetClicked)
        }
    }
}


@Preview(showBackground = true,
device = Devices.PIXEL_3A)
@Composable
fun SetItemComponentPreview(){
    val set = WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8)
    BaseCard{
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)){
            val duration = set.actions.stream().map { action-> action.duration }
                .reduce { count, accumulate -> count + accumulate }.get().toString()
            Column(Modifier.fillMaxWidth()){
                Row {
                    Column(Modifier.weight(7f)) {
                        BaseText(title = set.name)
                        BaseText(title = "Elapsed time: $duration ms")
                    }
                    Row(
                        Modifier
                            .weight(3f)
                            .padding(6.dp)
                            .fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        IconButton(
                            onClick = { },
                        ){
                            Icon(
                                Icons.Filled.PlayArrow,
                                contentDescription = "Localized description",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }
                        IconButton(
                            onClick = { },
                        ){
                            Icon(
                                Icons.Filled.Edit,
                                contentDescription = "Localized description",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true,
device = Devices.PIXEL_3A)
@Composable
fun SetItemListPreview(){
    val setList = Arrays.asList(WorkoutSet(setId = 1, name = "Tabata", actions = listOf(SetAction(1, "Rest", 5000)), rounds = 3),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8),
        WorkoutSet(1, "Tabata", listOf(SetAction(1, "Rest", 5000)), 8))

    LazyColumn(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize(),
        contentPadding = PaddingValues(10.dp)
    ){
        items(setList) { set ->
            SetItemComponent(set,
                {  },
                {  })
        }
    }
}


