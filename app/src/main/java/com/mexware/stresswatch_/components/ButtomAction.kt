package com.mexware.stresswatch_.components

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ButtomAction(
    text: String, // Texto que se mostrará en el botón
    onClick: () -> Unit, // Acción a realizar al presionar el botón
    backgroundColor: Color = Color(0xFFFF5722), // Color de fondo del botón (por defecto naranja)
    textColor: Color = Color.White, // Color del texto dentro del botón (por defecto blanco)
    fontSize: TextUnit = 18.sp, // Tamaño del texto
    fontWeight: FontWeight = FontWeight.Bold, // Peso de la tipografía
    modifier: Modifier = Modifier // Modificador opcional para personalizar el botón
){
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor, // Color de fondo
            contentColor = textColor // Color del contenido (texto)
        ),
        modifier = modifier // Permite personalizar el tamaño y el espacio del botón
    ) {
        Text(
            text = text,
            color = textColor, // Color del texto
            fontSize = fontSize, // Tamaño de la letra
            fontWeight = fontWeight // Peso de la tipografía
        )
    }

}