package com.mexware.stresswatch_.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextField(
    name: String, // El texto a mostrar
    modifier: Modifier = Modifier, // Modificador para configuraciones externas
    textColor: Color = Color(0xFFFFFDD0), // Color del texto por defecto
    fontSize: TextUnit = 16.sp, // Tamaño de la fuente
    fontWeight: FontWeight = FontWeight.Black, // Peso de la fuente
    fontFamily: FontFamily = FontFamily.Default // Familia tipográfica (Inter)
) {
    Row(modifier = modifier) {
        Text(
            text = name,
            fontSize = fontSize,
            fontWeight = fontWeight,
            color = textColor,
        )
    }
}
