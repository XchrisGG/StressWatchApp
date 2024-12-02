package com.mexware.stresswatch_.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            Column { // Envuelve el TopAppBar en una columna para incluir la línea
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF022B53) // Color del TopAppBar
                    ),
                    title = { Text("Chat StressWatch") },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.popBackStack()

                        }) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Volver a la pagina anteriro")
                        }
                    }

                )
                Divider(color = androidx.compose.ui.graphics.Color.White, thickness = 1.dp) // Línea blanca debajo del TopAppBar
            }

        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFADD8E6), // Color de fondo
                contentColor = androidx.compose.ui.graphics.Color.Red // Color del contenido
            ) {
                // Aquí irá el contenido de la barra, como botones u otros elementos
            }
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