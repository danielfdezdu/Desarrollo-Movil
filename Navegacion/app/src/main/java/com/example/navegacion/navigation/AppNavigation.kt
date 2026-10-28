package com.example.navegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacion.ui.screens.ListasMVVMScreen
import com.example.navegacion.ui.screens.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppPantallas.FirstScreen.route
    ) {
        composable(AppPantallas.FirstScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(AppPantallas.SecondScreen.route) {
            ListasMVVMScreen(navController = navController)
        }
    }
}
