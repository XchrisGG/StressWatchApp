package dev.mexware.stresswatch.feature.chat.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.mexware.stresswatch.ui.theme.StressMint

/**
 * Barra de entrada (campo + botón enviar) con colores fijos.
 */
@Composable
fun ChatInputBar(
    value: String,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit,
    enabled: Boolean
) {
          // barra inferior del Figma
    val fieldBg = Color(0xFFBFE6DC)     // campo claro
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(StressMint)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .weight(1f)
                .height(46.dp),
            placeholder = { Text("Escribe tu mensaje…") },
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = fieldBg,
                unfocusedContainerColor = fieldBg,
                cursorColor = Color(0xFF0D0D0D),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            singleLine = true
        )
        Spacer(Modifier.width(8.dp))
        FilledIconButton(
            onClick = onSend,
            enabled = enabled
        ) { Icon(Icons.Filled.Send, contentDescription = "Enviar") }
    }
}