package com.demo.justworktimer.feature.workout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@Composable
fun WorkoutCoordinator(
    viewModel: WorkoutViewModel = hiltViewModel()
) {
    // State observing and declarations
    val state by viewModel.stateFlow.collectAsState(initial = WorkoutState())

    // Events Handling
    LaunchedEffect(key1 = Unit) {
        viewModel.eventFlow
            .onEach {

            }
            .launchIn(this)
    }

    // UI Actions
    val actions = rememberWorkoutActions()


    // UI Rendering
    ProvideWorkoutActions(actions) {
        WorkoutScreen(state, actions)
    }
}


@Composable
fun rememberWorkoutActions(): WorkoutActions {
    return remember { WorkoutActions() }
}