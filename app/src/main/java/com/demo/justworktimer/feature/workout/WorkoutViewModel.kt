package com.demo.justworktimer.feature.workout

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val _eventFlow: MutableSharedFlow<WorkoutEvent> = MutableSharedFlow()
    private val _stateFlow: MutableStateFlow<WorkoutState> = MutableStateFlow(WorkoutState())

    val stateFlow: Flow<WorkoutState> = _stateFlow
    val eventFlow: Flow<WorkoutEvent> = _eventFlow


    private fun postEvent(event: WorkoutEvent) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }


}