package com.example.listasmvvm.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ListasMVVMViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ListasMVVMUiState())
    val uiState: StateFlow<ListasMVVMUiState> = _uiState.asStateFlow()

    fun cambiarFavorito(pelicula: Pelicula) {
        _uiState.update { estado -> estado.copy(
            peliculas = estado.peliculas.map {
                if (it.titulo == pelicula.titulo) it.copy(esFavorito = !it.esFavorito)
                else it
            }
            )
        }
    }

    fun eliminarPelicula(pelicula: Pelicula) {
        _uiState.update { it.copy(peliculas = it.peliculas - pelicula) }
    }

    fun engadirPelicula(pelicula: Pelicula) {
        _uiState.update { it.copy(peliculas = it.peliculas + pelicula) }
    }

}