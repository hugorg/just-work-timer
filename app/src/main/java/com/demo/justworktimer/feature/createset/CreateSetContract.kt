package com.demo.justworktimer.feature.createset

import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import com.demo.justworktimer.persistance.entity.SetAction


/**
 * UI State that represents CreateSetScreen
 **/
class CreateSetState{
    val setName = mutableStateOf(TextFieldValue())
    val rounds = mutableStateOf(TextFieldValue())
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
    val saveSetClicked: () -> Unit = {},
    val createAction: (SetAction) -> Unit = {}
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

