package com.example.contador.ui.pantallas.contador

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun contador() {

    var numero1 by rememberSaveable {
        mutableStateOf(0)
    }
    var numero2 by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Aquí irá a chamada á función que pintará os elementos da pantalla
        contadorScreen(
            valor1 = numero1,
            valor2 = numero2,
            operacion1 = {numero1++},
            operacion2 = {numero2++},
            eliminar1 = {numero1 = 0},
            eliminar2 = {numero2 = 0},
            eliminar3 = {numero1 = 0
                         numero2 = 0}
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