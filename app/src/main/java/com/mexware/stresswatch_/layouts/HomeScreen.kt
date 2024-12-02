package com.mexware.stresswatch_.layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navController: NavController){

    Scaffold(
        topBar = {
            Column { // Envuelve el TopAppBar en una columna para incluir la línea
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF022B53) // Color del TopAppBar
                    ),
                    title = { Text("Home") }
                )
                Divider(color = androidx.compose.ui.graphics.Color.White, thickness = 1.dp) // Línea blanca debajo del TopAppBar
            }

        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFADD8E6), // Color de fondo
                contentColor = androidx.compose.ui.graphics.Color.Red // Color del contenido
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    IconButton(onClick = { navController.navigate("chat") }) {
                        Icon(Icons.Filled.Home, contentDescription = "Inicio")
                    }
                    IconButton(onClick = { /* Acción para el botón izquierdo */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Inicio")
                    }
                    IconButton(onClick = { /* Acción para el botón izquierdo */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Inicio")
                    }


                }
            }
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
@Composable
fun OptionCard(
    title: String,         // Texto principal
    subtitle: String,      // Texto secundario
    icon: ImageVector,     // Ícono que aparece al lado
    backgroundColor: Color,// Color de fondo
    onClick: () -> Unit    // Acción al hacer clic
) {
    Card(
        modifier = Modifier
            .fillMaxWidth() // La tarjeta ocupa todo el ancho disponible
            .padding(horizontal = 16.dp, vertical = 50.dp) // Margen externo
            .clickable { onClick() }, // Agrega acción de clic
        colors = CardDefaults.cardColors(containerColor = backgroundColor) // Color de fondo
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp), // Margen interno
            verticalAlignment = Alignment.CenterVertically // Ícono y texto centrados verticalmente
        ) {
            Icon(
                imageVector = icon, // Ícono pasado como parámetro
                contentDescription = null, // El ícono no necesita descripción aquí
                tint = Color(0xFF022B53), // Ícono en azul oscuro
                modifier = Modifier.size(40.dp) // Tamaño del ícono
            )
            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre el ícono y el texto
            Column {
                Text(
                    text = title, // Título principal
                    color = Color(0xFF022B53), // Texto en azul oscuro
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = subtitle, // Subtítulo
                    color = Color(0xFF022B53), // Texto en azul oscuro
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
