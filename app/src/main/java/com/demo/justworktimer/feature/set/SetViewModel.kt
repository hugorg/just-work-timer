package com.demo.justworktimer.feature.set

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
class SetViewModel @Inject constructor(
    private var setRepo: SetRepo,
    savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val _eventFlow: MutableSharedFlow<SetEvent> = MutableSharedFlow()
    private val _stateFlow: MutableStateFlow<SetState> = MutableStateFlow(SetState())

    val stateFlow: Flow<SetState> = _stateFlow
    val eventFlow: Flow<SetEvent> = _eventFlow


    private fun postEvent(event: SetEvent) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }



}