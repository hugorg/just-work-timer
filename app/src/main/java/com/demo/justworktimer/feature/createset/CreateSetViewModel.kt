package com.demo.justworktimer.feature.createset

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
class CreateSetViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _eventFlow: MutableSharedFlow<CreateSetEvent> = MutableSharedFlow()
    private val _stateFlow: MutableStateFlow<CreateSetState> = MutableStateFlow(CreateSetState())

    val stateFlow: Flow<CreateSetState> = _stateFlow
    val eventFlow: Flow<CreateSetEvent> = _eventFlow


    private fun postEvent(event: CreateSetEvent) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }


}