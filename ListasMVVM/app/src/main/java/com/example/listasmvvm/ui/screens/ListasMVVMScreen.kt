package com.example.listasmvvm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.OndemandVideo
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listasmvvm.state.ListasMVVMViewModel
import com.example.listasmvvm.state.Pelicula

@Composable
fun ListasMVVMScreen(
    modifier: Modifier = Modifier,
    viewModel: ListasMVVMViewModel
) {
    val state by viewModel.uiState.collectAsState()
    val totalPeliculas = state.peliculas.size
    val totalFavoritos = state.peliculas.count { it.esFavorito }

    var textoTitulo by remember { mutableStateOf("") }
    var textoAutor by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { PintaTopBar() },
        bottomBar = { PintaBottomBar(total = totalPeliculas, favoritos = totalFavoritos) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = textoTitulo,
                onValueChange = { textoTitulo = it },
                label = { Text("Película") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = textoAutor,
                onValueChange = { textoAutor = it },
                label = { Text("Autor") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    if (textoTitulo.isNotBlank()) {
                        viewModel.engadirPelicula(
                            Pelicula(
                                id = (state.peliculas.maxOfOrNull { it.id } ?: 0) + 1,
                                titulo = textoTitulo,
                                autor = textoAutor
                            )
                        )
                        textoTitulo = ""
                        textoAutor = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Engadir")
            }

            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "Películas",
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.size(15.dp))
            state.peliculas.forEach { pelicula ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .background(Color(0xFF53398C), shape = RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.OndemandVideo,
                            contentDescription = "Película",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        TituloPelicula(pelicula.titulo)
                        Spacer(modifier = Modifier.size(4.dp))
                        AutorPelicula(pelicula.autor)
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Estrella(isClicked = pelicula.esFavorito) {
                            viewModel.cambiarFavorito(pelicula)
                        }
                        Papelera {
                            viewModel.eliminarPelicula(pelicula)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PintaTopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF53398C))
            .padding(start = 15.dp, top = 40.dp, bottom = 18.dp, end = 15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                color = Color.White,
                text = "A miña lista de películas",
                fontSize = 20.sp,
            )
            Icon(
                tint = Color.White,
                imageVector = Icons.Default.ClearAll,
                contentDescription = "Settings"
            )
        }
    }
}

@Composable
fun PintaBottomBar(total: Int, favoritos: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF53398C))
            .padding(horizontal = 20.dp, vertical = 18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    tint = Color.White,
                    imageVector = Icons.Default.FormatListNumbered,
                    contentDescription = "Lista"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    color = Color.White,
                    text = "Total: $total",
                    fontSize = 16.sp,
                )
            }

            Text(
                color = Color.White,
                text = "|",
                fontSize = 18.sp,
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    tint = Color.White,
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favoritos"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    color = Color.White,
                    text = "Favoritos: $favoritos",
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@Composable
fun TituloPelicula(titulo: String) {
    Text(
        text = titulo,
        fontSize = 18.sp
    )
}

@Composable
fun AutorPelicula(autor: String) {
    Text(
        text = autor,
        color = Color(0xFF797979),
        fontSize = 12.sp
    )
}

@Composable
fun Estrella(isClicked: Boolean, onClick: () -> Unit) {
    val iconColor = if (isClicked) Color(0xFFA88C29) else Color(0xFF363636)
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Estrella",
            tint = iconColor
        )
    }
}

@Composable
fun Papelera(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            tint = Color(0xFF982929),
            imageVector = Icons.Default.Delete,
            contentDescription = "Papelera"
        )
    }
}
