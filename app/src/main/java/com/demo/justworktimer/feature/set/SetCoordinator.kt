package com.demo.justworktimer.feature.set

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.demo.justworktimer.ui.navigation.Navigator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@Composable
fun SetCoordinator(
    navigator: Navigator,
    viewModel: SetViewModel = hiltViewModel()
) {
    // State observing and declarations
    val state by viewModel.stateFlow.collectAsState(initial = SetState())

    // Events Handling
    LaunchedEffect(key1 = Unit) {
        viewModel.eventFlow
            .onEach { event->

            }
            .launchIn(this)
    }

    // UI Actions
    val actions = rememberSetActions(navigator)


    // UI Rendering
    ProvideSetActions(actions) {
        SetScreen(state, actions)
    }
}


@Composable
fun rememberSetActions(navigator: Navigator): SetActions {
    return remember { SetActions(
        onNewSetClicked = {
            navigator.navigateTo(Navigator.NavTarget.NewSet)
        },
        onPlaySetClicked = {
            navigator.navigateTo(Navigator.NavTarget.NewSet.setId(it))
        }
    ) }
}