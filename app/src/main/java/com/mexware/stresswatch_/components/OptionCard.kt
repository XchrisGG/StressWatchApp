package com.mexware.stresswatch_.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

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