package com.mexware.stresswatch_.layouts
import com.mexware.stresswatch_.components.TopApp
import com.mexware.stresswatch_.components.BottomAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mexware.stresswatch_.components.OptionCard

@Composable
fun UserScreen( navController: NavController){

    Scaffold(
        topBar = {
            TopApp(navController = navController, title = "Usuario")

        },

        bottomBar = {
            BottomAppBar(navController = navController)
        }

    ){ padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFF022B53)) // Fondo azul oscuro
                .verticalScroll(rememberScrollState()), // Permitir scroll si es necesario
            horizontalAlignment = Alignment.CenterHorizontally // Centrar contenido
        ) {
            Text(
                text = "Buenos días, Christian", // Texto de bienvenida
                color = androidx.compose.ui.graphics.Color.White,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .fillMaxWidth() // Hace que el texto ocupe todo el ancho disponible
                    .padding(start = 16.dp) // Margen desde la izquierda
                    .align(Alignment.Start) // Alinea el texto hacia la izquierda
            )
            Spacer(modifier = Modifier.height(16.dp))

            OptionCard(
                title = "Mi registro emocional",
                subtitle = "¿Cómo te has sentido hoy?",
                icon = Icons.Filled.Home, // Puedes cambiar este ícono
                backgroundColor = Color(0xFFADD8E6), // Azul claro
                onClick = { /* Acción para registro emocional */ }
            )

            // Tarjeta: Empieza hoy mismo tu nuevo objetivo
            OptionCard(
                title = "Empieza hoy mismo tu nuevo objetivo",
                subtitle = "¿Fijar objetivo?",
                icon = Icons.Filled.Home, // Ícono personalizado
                backgroundColor = Color(0xFFADD8E6), // Azul claro
                onClick = { /* Acción para fijar objetivo */ }
            )

            // Tarjeta: Espacio de relajación
            OptionCard(
                title = "Espacio de relajación",
                subtitle = "¿Listo?",
                icon = Icons.Filled.Home, // Ícono personalizado
                backgroundColor = Color(0xFFADD8E6), // Azul claro
                onClick = { /* Acción para espacio de relajación */ }
            )

        }


    }
}
