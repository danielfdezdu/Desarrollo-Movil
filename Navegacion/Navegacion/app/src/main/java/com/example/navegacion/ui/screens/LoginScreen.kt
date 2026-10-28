package com.example.navegacion.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navegacion.navigation.AppPantallas

@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {

    // Creamos todas las variables

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var rememberMe by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = modifier,
        topBar = { pintaTopBar() },
        bottomBar = { pintaBottomBar() }
    ) { innerPadding ->

        // Hacemos el background

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFF0D0E12)),
            contentAlignment = Alignment.Center
        ) {

        // Hacemos el Rectangulo donde contener toda la información

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFF222126))
                .padding(
                    start = 37.dp,
                    end = 37.dp,
                    top = 18.dp,
                    bottom = 25.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Hacemos una box redonda y dentro metemos el icono de la persona

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFB9C3EC)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Bedtime,
                    contentDescription = "Usuario",
                    tint = Color(0xFF333F60),
                    modifier = Modifier.size(55.dp)
                )
            }

            // Espaciamos

            Spacer(modifier = Modifier.height(20.dp))

            // Hacemos un recuadro para el nombre de usuario

            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                placeholder = {
                    Text(
                        text = "Nombre de Usuario",
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Usuario"
                    )
                },
                shape = RoundedCornerShape(30.dp),
                singleLine = true
            )

            // Espaciamos

            Spacer(modifier = Modifier.height(10.dp))

            // Hacemos un recuadro para la contraseña

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                placeholder = {
                    Text(
                        text = "Contraseña",
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password"
                    )
                },
                shape = RoundedCornerShape(45.dp),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation()

            )

            // Espaciamos

            Spacer(modifier = Modifier.height(30.dp))

            // Hacemos el botón del Login

            Button(
                onClick = {
                    navController.navigate(AppPantallas.SecondScreen.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    text = "INICIAR SESIÓN",
                    fontSize = 12.sp
                )
            }

            // Espaciamos

            Spacer(modifier = Modifier.height(30.dp))

            // Hacemos una fila donde ponemos información adicional

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // Hacemos una fila adicional donde ponemos un Checkbox y un texto que diga si quiere que recordemos la contraseña

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = {
                            rememberMe = it
                        }
                    )

                    Text(
                        text = "Recuérdame",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }

                // Hacemos un texto preguntando si olvido la contraseña

                Text(
                    text = "Olvidó su contraseña?",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
    }
}

@Composable
fun pintaTopBar() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(vertical = 30.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFF222126))
            .padding(
                start = 37.dp,
                end = 37.dp,
                top = 18.dp,
                bottom = 18.dp
            )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Icon(
                tint = Color.Gray,
                imageVector = Icons.Default.Search,
                contentDescription = "Usuario"
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                color = Color.Gray,
                text = "Barra de Búsqueda",
                fontSize = 20.sp,
            )
        }
    }

}

@Composable
fun pintaBottomBar() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(vertical = 30.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFF222126))
            .padding(
                start = 37.dp,
                end = 37.dp,
                top = 18.dp,
                bottom = 18.dp
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Icon(
                tint = Color.Gray,
                imageVector = Icons.Default.Settings,
                contentDescription = "Usuario"
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                color = Color.Gray,
                text = "Configuración",
                fontSize = 20.sp,
            )
        }
    }

}