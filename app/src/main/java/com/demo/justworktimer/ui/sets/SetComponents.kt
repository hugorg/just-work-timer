package com.demo.justworktimer.ui.sets

import android.widget.Space
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.sharp.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.justworktimer.data.entity.SetAction
import com.demo.justworktimer.data.entity.WorkoutSet

@Composable
fun SetItemComponent(set: WorkoutSet) {
    Surface(shadowElevation = 4.dp,
        tonalElevation = 6.dp ,
        shape = MaterialTheme.shapes.large) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            val duration = set.actions.stream().map { action-> action.duration }
                .reduce { count, accumulate -> count + accumulate }.get().toString()
            Column(Modifier.fillMaxWidth()){
                Row {
                    Column(Modifier.weight(7f)) {
                        Text(text = set.name,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSecondaryContainer)
                        Text(text = "Elapsed time: $duration ms",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSecondaryContainer)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetItemList(items : List<WorkoutSet>){
        LazyColumn(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize(),
            contentPadding = PaddingValues(10.dp)
        ){
            items(items) { set ->
                SetItemComponent(set)
            }
        }
}


@Preview(showBackground = true,
device = Devices.PIXEL_3A)
@Composable
fun SetItemComponentPreview(){
    val set = WorkoutSet(1,
        "Tabata",
        actions = listOf(SetAction(1, "Rest", 5000))
    )
    Surface(shadowElevation = 0.dp,
        tonalElevation = 6.dp ,
        shape = MaterialTheme.shapes.large) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            val duration = set.actions.stream().map { action-> action.duration }
                .reduce { count, accumulate -> count + accumulate }.get().toString()
            Column(Modifier.fillMaxWidth()){
                Row {
                    Column(Modifier.weight(7f)) {
                        Text(text = set.name,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSecondaryContainer)
                        Text(text = "Elapsed time: $duration ms",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSecondaryContainer)
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
