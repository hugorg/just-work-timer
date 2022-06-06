package com.demo.justworktimer.feature.createset

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@Composable
fun CreateSetCoordinator(
    viewModel: CreateSetViewModel = hiltViewModel()
) {
    // State observing and declarations
    val state by viewModel.stateFlow.collectAsState(initial = CreateSetState())

    // Events Handling
    LaunchedEffect(key1 = Unit) {
        viewModel.eventFlow
            .onEach { /* Handle Events */ }
            .launchIn(this)
    }

    // UI Actions
    val actions = rememberCreateSetActions()


    // UI Rendering
    ProvideCreateSetActions(actions) {
        CreateSetScreen(state, actions)
    }
}


@Composable
fun rememberCreateSetActions(): CreateSetActions {
    return remember { CreateSetActions() }
}