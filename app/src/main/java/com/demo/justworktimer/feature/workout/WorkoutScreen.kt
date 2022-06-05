package com.demo.justworktimer.feature.workout

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WorkoutScreen(
    state: WorkoutState = WorkoutState(),
    actions: WorkoutActions = LocalWorkoutActions.current
) {
    // TODO UI Logic
}

@Composable
@Preview
private fun WorkoutScreenPreview() {
    WorkoutScreen()
}

