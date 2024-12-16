package com.mexware.stresswatch_.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleTextCard(
    text: String,            // Texto que aparece en la tarjeta
    backgroundColor: Color, // Color de fondo
    onClick: () -> Unit      // Acción al hacer clic
) {
    Card(
        modifier = Modifier
            .fillMaxWidth() // La tarjeta ocupa todo el ancho disponible
            .padding(horizontal = 16.dp, vertical = 50.dp) // Margen externo
            .clickable { onClick() }, // Agrega acción de clic
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inversePrimary) // Color de fondo
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp), // Margen interno
            horizontalAlignment = Alignment.CenterHorizontally // Centra el texto
        ) {
            Text(
                text = text, // Texto que se pasa como parámetro
                color = Color(0xFF022B53), // Color del texto (puedes modificarlo)
                style = MaterialTheme.typography.titleMedium // Estilo del texto
            )
        }
    }
}
