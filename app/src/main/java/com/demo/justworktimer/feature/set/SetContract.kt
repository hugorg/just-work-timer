package com.demo.justworktimer.feature.set

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.demo.justworktimer.data.entity.WorkoutSet
import com.demo.justworktimer.feature.workout.WorkoutViewModel_HiltModules_KeyModule_ProvideFactory


/**
 * UI State that represents SetScreen
 **/
class SetState

/**
 * Set events emitted from the ViewModel and handled in the UI layer
 * i.e ViewModel -> Coordinator
 **/
sealed interface SetEvent{

}

/**
 * Set Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class SetActions(
    val onNewSetClicked: () -> Unit = {},
    val onPlaySetClicked: (Int) -> Unit = {},
    val onEditSetClicked: (Int) -> Unit = {}
)

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalSetActions = staticCompositionLocalOf { SetActions() }

@Composable
fun ProvideSetActions(actions: SetActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalSetActions provides actions) {
        content.invoke()
    }
}

