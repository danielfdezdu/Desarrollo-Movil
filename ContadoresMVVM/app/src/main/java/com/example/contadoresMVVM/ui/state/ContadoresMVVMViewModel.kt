package com.example.contadoresMVVM.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// UiState (No hace falta hacer una clase separada se puede poner aqui)
data class ContadoresMVVMUiState(
    val numero1: Int = 0,
    val numero2: Int = 0
)

class ContadoresMVVMViewModel : ViewModel() {

    // Estado privado modificable
    private val _uiState = MutableStateFlow(ContadoresMVVMUiState())
    // Estado público de solo lectura para la UI
    val uiState: StateFlow<ContadoresMVVMUiState> = _uiState.asStateFlow()

    // Acciones (Eventos de usuario)
    fun incrementar1() {
        _uiState.update { it.copy(numero1 = it.numero1 + 1) }
    }

    fun incrementar2() {
        _uiState.update { it.copy(numero2 = it.numero2 + 1) }
    }

    fun reiniciar1() {
        _uiState.update { it.copy(numero1 = 0) }
    }

    fun reiniciar2() {
        _uiState.update { it.copy(numero2 = 0) }
    }

    fun reiniciarTodo() {
        _uiState.update { ContadoresMVVMUiState(0, 0) }
    }
}