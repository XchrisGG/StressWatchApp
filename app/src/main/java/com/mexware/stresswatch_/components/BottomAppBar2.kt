package com.mexware.stresswatch_.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.mexware.stresswatch_.ui.theme.stresswatchthme.AppTheme

@Composable
fun BottomAppBar2(
    onBackClick: () -> Unit,  // Función para la acción de la flecha
    onNextClick: () -> Unit   // Función para la acción del texto "Siguiente"
) {
    AppTheme {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.inversePrimary// Color de fondo
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Flecha apuntando hacia la izquierda (color negro)
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Atras",
                    tint = Color.Black // Establecer color negro
                )
            }

            // Botón de texto "Siguiente"
            TextButton(onClick = { onNextClick() }) {
                Text(text = "Siguiente", fontSize = 18.sp, color = MaterialTheme.colorScheme.onTertiaryContainer)
            }
        }
    }
    }
}
