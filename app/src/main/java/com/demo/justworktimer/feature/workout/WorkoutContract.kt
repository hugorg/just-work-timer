package com.demo.justworktimer.feature.workout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


/**
 * UI State that represents WorkoutScreen
 **/
class WorkoutState

/**
 * Workout events emitted from the ViewModel and handled in the UI layer
 * i.e ViewModel -> Coordinator
 **/
sealed interface WorkoutEvent{

}

/**
 * Workout Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class WorkoutActions(
    val onClick: () -> Unit = {}
)

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalWorkoutActions = staticCompositionLocalOf { WorkoutActions() }

@Composable
fun ProvideWorkoutActions(actions: WorkoutActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalWorkoutActions provides actions) {
        content.invoke()
    }
}

