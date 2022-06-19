package com.demo.justworktimer.feature.createaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.justworktimer.persistance.entity.SetAction
import com.demo.justworktimer.ui.basecomponents.BaseCard
import com.demo.justworktimer.ui.basecomponents.BaseText

@Composable
fun ActionItemList(
    items: List<SetAction>,
    onRemove : (SetAction) -> Unit,
){
    LazyColumn(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(10.dp)
    ){
        items(items) { actions ->
            SetActionComponent(actions, onRemove)
        }
    }
}

@Composable
fun SetActionComponent(action: SetAction, onRemove : (SetAction) -> Unit) {
    BaseCard{
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)){
            val duration = action.duration.toString()
            Column(Modifier.fillMaxWidth()){
                Row {
                    Column(Modifier.weight(7f)) {
                        BaseText(title = action.actionName)
                        BaseText(title = "Elapsed time: $duration ms")
                    }
                    Row(
                        Modifier
                            .weight(3f)
                            .padding(6.dp)
                            .fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        IconButton(
                            onClick = { onRemove.invoke(action) },
                        ){
                            Icon(
                                Icons.Filled.Delete,
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

