package com.dan.randomapi.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.dan.randomapi.data.model.ResultProfile
import com.dan.randomapi.domain.ProfileUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val listUseCase : ProfileUseCase
):ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state : StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val listProfiles = listUseCase()
            _state.update { it.copy(listUsers = listProfiles) }
            _state.update { it.copy(loading = false) }
        }
    }

    data class UiState(
        val loading : Boolean = false,
        val listUsers : List<ResultProfile>? = null
    )

    @Suppress("UNCHECKED_CAST")
    class MainViewModelFactory(private val listUseCase : ProfileUseCase):ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(listUseCase) as T
        }
    }
}

