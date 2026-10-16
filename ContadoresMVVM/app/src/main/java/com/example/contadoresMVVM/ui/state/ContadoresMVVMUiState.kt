package com.example.contadoresMVVM.ui.state

class ContadoresMVVMUiState {

    data class Producto(
        val id: Int,
        val nombre: String,
        val comprado: Boolean = false
    )

    data class ListaCompraUiState(
        val productos: List<Producto> = emptyList(),
        val nuevoProducto: String = ""
    ) {
        // Propiedad calculada a partir del estado
        val pendientes: Int get() = productos.count { !it.comprado }
    }

}