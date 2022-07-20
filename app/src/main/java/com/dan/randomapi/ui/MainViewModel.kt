package com.dan.randomapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.randomapi.data.model.ResultProfile
import com.dan.randomapi.domain.ProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var listUseCase = ProfileUseCase()

    private val _state = MutableStateFlow(UiState())
    val state : StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val listProfiles = listUseCase.getAllProfiles()
            _state.update { it.copy(listUsers = listProfiles) }
            _state.update { it.copy(loading = false) }
        }
    }

    data class UiState(
        val loading : Boolean = false,
        val listUsers : List<ResultProfile>? = null
    )

}