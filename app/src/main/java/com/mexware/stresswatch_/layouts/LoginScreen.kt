package com.mexware.stresswatch_.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mexware.stresswatch_.R
import com.mexware.stresswatch_.components.ButtonAction
import com.mexware.stresswatch_.components.CustomPasswordField
import com.mexware.stresswatch_.components.CustomTextField

@Composable
fun LoginScreen(navController: NavHostController) {
    var textFieldValue by remember { mutableStateOf("") }
    var passwordFieldValue by remember { mutableStateOf("") }
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

            Spacer(modifier = Modifier.height(25.dp)) // Espaciado

            CustomTextField(
                value = textFieldValue, // Estado que almacena el texto ingresado
                onValueChange = { newText -> textFieldValue = newText },
                placeholder = "Ingresa Tu nombre", // Texto del placeholder
                modifier = Modifier.fillMaxWidth(0.9f) // Ajusta el ancho si es necesario
            )

            Spacer(modifier = Modifier.height(25.dp)) // Espaciado

            CustomPasswordField(
                value = passwordFieldValue,
                onValueChange = { newPassword -> passwordFieldValue = newPassword },
                placeholder = "Ingresa tu contraseña",
                modifier = Modifier.fillMaxWidth(0.9f)
            )

            Spacer(modifier = Modifier.height(50.dp)) // Espaciado

            // Alineamos el botón a la derecha con un margen derecho
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp), // Espaciado desde el borde derecho
                horizontalArrangement = Arrangement.End // Alineamos a la derecha
            ) {
                ButtonAction(
                    text = "Inicar Sesión", // Texto del botón
                    onClick = { /* Acción del botón */ },
                    fontSize = 18, // Tamaño del texto (en SP)
                    modifier = Modifier.height(56.dp) // Tamaño del botón (ancho y alto)
                )
            }

        }
    }
}
