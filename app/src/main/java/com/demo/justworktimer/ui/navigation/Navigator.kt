package com.demo.justworktimer.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.demo.justworktimer.feature.createset.CreateSetCoordinator
import com.demo.justworktimer.feature.createset.CreateSetViewModel
import com.demo.justworktimer.feature.set.SetCoordinator
import com.demo.justworktimer.feature.set.SetViewModel
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

    enum class NavTarget(var label: String, var id: Int = 0) {
        Workouts("workout", 0),
        Sets("sets", 0),
        WorkoutPlayer("player", 0),
        CreateSet("createSet",0);

        fun setId(id: Int): NavTarget {
            this.id = id;
            return this
        }
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
            val setViewModel = hiltViewModel<SetViewModel>()
            SetCoordinator(navigator = navigator,
                            viewModel = setViewModel)
        }
        composable(Navigator.NavTarget.Workouts.label) {
            //FriendsList(/*...*/)
        }
        composable(Navigator.NavTarget.WorkoutPlayer.label) {
            //FriendsList(/*...*/)
        }
        composable(Navigator.NavTarget.CreateSet.label) {
            val createSetViewModel = hiltViewModel<CreateSetViewModel>()
            CreateSetCoordinator(viewModel = createSetViewModel)
        }
    }
}