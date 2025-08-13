package dev.mexware.stresswatch.feature.auth.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mexware.stresswatch.ui.theme.StressBlack
import dev.mexware.stresswatch.ui.theme.StressMint

/**
 * Botón estilo "píldora" con colores fijos (no depende del theme).
 * Se usa para seleccionar género.
 */
@Composable
fun GenderPillButton(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Colores estáticos del Figma
    val green =  StressMint
    val textColor = StressBlack
    val greenDisabled = green.copy(alpha = 0.75f)

    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = if (selected) 4.dp else 0.dp,
            pressedElevation = 2.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = green,
            contentColor = textColor,
            disabledContainerColor = greenDisabled,
            disabledContentColor = textColor
        )
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}