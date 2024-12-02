package com.mexware.stresswatch_.layouts

import com.mexware.stresswatch_.components.ButtomAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mexware.stresswatch_.R

@Composable
fun LoginRegisterScreen(navController: NavHostController) {
        Scaffold { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize() // Ocupa todo el espacio disponible
                    .padding(padding) // Respeta el padding del Scaffold
                    .background(Color(0xFF022B53)), // Color de fondo
                horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente
                verticalArrangement = Arrangement.Top // Comienza desde arriba
            ) {
                // Imagen
                Image(
                    modifier = Modifier
                        .size(400.dp)
                        .padding(top = 20.dp), // Espaciado superior opcional
                    painter = painterResource(id = R.drawable.watch),
                    contentDescription = "logo"
                )

                Spacer(modifier = Modifier.height(25.dp)) //

                // Botón
                ButtomAction(
                    text = "Iniciar Sesión",
                    onClick = { navController.navigate("Login") },
                    backgroundColor = Color(0xFF87CEEB), // Fondo naranja
                    textColor = Color.White, // Texto blanco
                    fontSize = 18.sp, // Tamaño del texto
                    fontWeight = FontWeight.Bold, // Texto en negrita
                    modifier = Modifier
                        .width(300.dp) // Ancho del botón
                        .padding(16.dp) // Margen alrededor del botón
                )
                ButtomAction(
                    text = "Registrarte",
                    onClick ={ navController.navigate("Login") },
                    backgroundColor = Color(0xFF87CEEB), // Fondo naranja
                    textColor = Color.White, // Texto blanco
                    fontSize = 18.sp, // Tamaño del texto
                    fontWeight = FontWeight.Bold, // Texto en negrita
                    modifier = Modifier
                        .width(300.dp) // Ancho del botón
                        .padding(16.dp) // Margen alrededor del botón
                )

            }
        }
    }
