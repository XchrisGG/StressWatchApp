package com.mexware.stresswatch_.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mexware.stresswatch_.ui.theme.stresswatchthme.AppTheme

@Composable
fun ButtonAction(
    text: String, // Texto del botón
    onClick: () -> Unit, // Acción al hacer clic
    modifier: Modifier = Modifier.fillMaxWidth(0.8f).height(64.dp), // Modificador por defecto
    backgroundColor: Color = Color(0xFF87CEEB).copy(alpha = 0.9f), // Color de fondo
    textColor: Color = Color(0xFFFFFDD0), // Color del texto
    fontSize: Int = 24 // Tamaño de la fuente en SP
) {
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            contentColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.surfaceContainerLow,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Black
        )
    }

}
