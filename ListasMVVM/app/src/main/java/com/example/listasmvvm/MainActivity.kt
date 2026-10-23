package com.example.listasmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listasmvvm.state.ListasMVVMViewModel
import com.example.listasmvvm.ui.screens.ListasMVVMScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: ListasMVVMViewModel = viewModel()

            ListasMVVMScreen(viewModel = viewModel)
        }
    }
}