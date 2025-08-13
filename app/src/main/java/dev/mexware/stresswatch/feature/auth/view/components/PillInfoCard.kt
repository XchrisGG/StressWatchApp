package dev.mexware.stresswatch.feature.auth.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import dev.mexware.stresswatch.ui.theme.StressMint

/**
 * Tarjeta "tipo píldora" para mostrar mensajes del disclaimer.
 * Usa colores del tema (nada de hex).
 */
@Composable
fun PillInfoCard(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        color = StressMint,

    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 18.dp)
        )
    }
}
