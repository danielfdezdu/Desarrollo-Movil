package com.example.navegacion.navigation

sealed class AppPantallas(val route: String) {
    object FirstScreen : AppPantallas("first_screen")
    object SecondScreen : AppPantallas("second_screen")
}
