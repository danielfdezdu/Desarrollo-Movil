package com.example.contadoresMVVM.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contadoresMVVM.ui.viewmodel.ContadoresViewModel

@Composable
fun ContadorScreenRoot(
    viewModel: ContadoresViewModel = viewModel()
) {
    // Observamos el estado del ViewModel
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        contadorScreen(
            valor1 = uiState.numero1,
            valor2 = uiState.numero2,
            operacion1 = { viewModel.incrementar1() },
            operacion2 = { viewModel.incrementar2() },
            eliminar1 = { viewModel.reiniciar1() },
            eliminar2 = { viewModel.reiniciar2() },
            eliminar3 = { viewModel.reiniciarTodo() }
        )
    }
}

@Composable
fun contadorScreen(
    valor1: Int,
    valor2: Int,
    operacion1: () -> Unit,
    operacion2: () -> Unit,
    eliminar1: () -> Unit,
    eliminar2: () -> Unit,
    eliminar3: () -> Unit
) {
    Row() {
        boton (operacion1)

        Spacer(modifier = Modifier.size(15.dp))
        Column() {
            Spacer(modifier = Modifier.size(16.dp))
            texto(valor1)
        }
        Spacer(modifier = Modifier.size(20.dp))
        Column() {
            papelera(eliminar1)
        }
    }

    Row() {
        boton (operacion2)

        Spacer(modifier = Modifier.size(15.dp))
        Column() {
            Spacer(modifier = Modifier.size(16.dp))
            texto(valor2)
        }
        Spacer(modifier = Modifier.size(20.dp))
        Column() {
            papelera(eliminar2)
        }
    }

    Spacer(modifier = Modifier.size(10.dp))

    Row() {
        Column() {
            Spacer(modifier = Modifier.size(16.dp))
            texto(valor1 + valor2)
        }
        Spacer(modifier = Modifier.size(16.dp))
        papelera(eliminar3)
    }
}

// Función que chamará aos elementos a pintar

@Composable
fun boton(incrementar : () -> Unit) {    // Será a operación de incremento dunha variable
    Button(
        onClick = incrementar
    ) {
        Text(text = "Incrementar");
    }
}

@Composable
fun texto(valor: Int) {
    Text(
        text = "Contador: ${valor}"
    )
    Log.d("Incremento", valor.toString())
}

@Composable
fun papelera(cero : () -> Unit) {
    IconButton(
        onClick = cero,
    ) {
        Icon(
            tint = Color.Black,
            imageVector = Icons.Default.Delete,
            contentDescription = "Papelera"
        )
    }
}

@Preview
@Composable
fun ContadorPreview() {

}