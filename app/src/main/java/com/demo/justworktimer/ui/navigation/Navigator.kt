package com.demo.justworktimer.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.demo.justworktimer.data.entity.SetAction
import com.demo.justworktimer.data.entity.WorkoutSet
import com.demo.justworktimer.ui.sets.SetScreen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class Navigator {

    private val _sharedFlow = 
      MutableSharedFlow<NavTarget>(extraBufferCapacity = 1)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(navTarget: NavTarget) {
        _sharedFlow.tryEmit(navTarget)
    }

    enum class NavTarget(val label: String) {
        Workouts("workout"),
        Sets("sets"),
        WorkoutPlayer("player")
    }
}


@Composable
fun NavigationComponent(
    navController: NavHostController,
    navigator: Navigator
) {
    LaunchedEffect("navigation") {
        navigator.sharedFlow.onEach {
            navController.navigate(it.label)
        }.launchIn(this)
    }
    NavHost(
        navController = navController,
        startDestination = Navigator.NavTarget.Sets.label
    ) {
        composable(Navigator.NavTarget.Sets.label) {
            SetScreen(navigator)
        }
        composable(Navigator.NavTarget.Workouts.label) {
            //FriendsList(/*...*/)
        }
        composable(Navigator.NavTarget.WorkoutPlayer.label) {
            //FriendsList(/*...*/)
        }
    }
}