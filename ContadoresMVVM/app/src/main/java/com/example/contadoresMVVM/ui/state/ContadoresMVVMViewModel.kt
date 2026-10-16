package com.example.contadoresMVVM.ui.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContadoresMVVMViewModel : ViewModel() {

    // Estado mutable, solo accesible desde el ViewModel
    private val _uiState = MutableStateFlow(ContadoresMVVMUiState())

    // Estado de solo lectura que se expone a la UI
    val uiState: StateFlow<ContadoresMVVMUiState> = _uiState.asStateFlow()

}