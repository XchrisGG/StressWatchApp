package com.mexware.stresswatch_.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonAction(
    text: String, // Texto que se mostrará en el botón
    onClick: () -> Unit // Acción a realizar al presionar el botón
) {
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF87CEEB).copy(alpha = 0.9f), // Color de fondo con opacidad
            contentColor = Color(0xFFFFFDD0) // Color del texto
        ),
        modifier = Modifier
            .fillMaxWidth(0.8f) // Ocupa el 80% del ancho disponible
            .height(64.dp) // Altura fija
    ) {
        Text(
            text = text,
            color = Color(0xFFFFFDFD), // Color del texto
            fontSize = 24.sp, // Tamaño de la fuente
            fontWeight = FontWeight.Black // Peso de la tipografía
        )
    }
}
