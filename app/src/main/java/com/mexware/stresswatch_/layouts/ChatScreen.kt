package com.mexware.stresswatch_.layouts
import com.mexware.stresswatch_.components.TopApp
import com.mexware.stresswatch_.components.BottomAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController


@Composable
fun ChatScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopApp(navController = navController, title = "Chat")


        },

        bottomBar = {
            BottomAppBar(navController = navController)

        }

    ){ padding ->

        Box(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el espacio disponible
                .padding(padding) // Respeta el espacio de las barras
                .background(Color(0xFF022B53)) // Color de fondo del Box

        )

    }
}