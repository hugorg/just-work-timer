package com.demo.justworktimer.feature.createset

import androidx.compose.runtime.*
import com.demo.justworktimer.data.entity.SetAction


/**
 * UI State that represents CreateSetScreen
 **/
class CreateSetState{
    val setName = mutableStateOf("")
    val rounds = mutableStateOf("1")
    val setActions = mutableStateListOf<SetAction>()
}

/**
 * CreateSet events emitted from the ViewModel and handled in the UI layer
 * i.e ViewModel -> Coordinator
 **/
sealed interface CreateSetEvent{

}

/**
 * CreateSet Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class CreateSetActions(
    val saveSetClicked: () -> Unit = {}
)

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalCreateSetActions = staticCompositionLocalOf { CreateSetActions() }

@Composable
fun ProvideCreateSetActions(actions: CreateSetActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalCreateSetActions provides actions) {
        content.invoke()
    }
}

