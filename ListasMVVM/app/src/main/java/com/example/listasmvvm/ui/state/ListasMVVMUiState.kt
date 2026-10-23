package com.example.listasmvvm.state

data class Pelicula(
    val id: Int,
    val titulo: String,
    val autor: String,
    val esFavorito: Boolean = false
)

data class ListasMVVMUiState(
    val peliculas: List<Pelicula> = listOf(
        Pelicula(id = 1, titulo = "Interestellar", autor = "Christopher Nolan", esFavorito = false),
    )
)