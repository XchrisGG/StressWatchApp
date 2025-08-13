package dev.mexware.stresswatch.feature.sensors.view.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mexware.stresswatch.ui.theme.StressMint

/**
 * Tarjeta tipo “píldora” con icono a la derecha y descripción corta.
 * Colores fijos para igualar el Figma.
 */
@Composable
fun SensorInfoCard(
    title: String,
    description: String,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val cardBg = Color(0xFFCFE8F3)       // azul muy claro de la tarjeta
    val textColor = Color(0xFF0D0D0D)    // casi negro
    val bubbleBg = Color(0xFFBFE6DC)     // círculo detrás del ícono

    Surface(
        color = StressMint,
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = title,
                    color = textColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = description,
                    color = textColor.copy(alpha = 0.85f),
                    fontSize = 14.sp
                )
            }

            // Burbuja del icono (derecha)
            Surface(
                shape = CircleShape,
                color = bubbleBg,
                modifier = Modifier.size(56.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = iconRes),
                        contentDescription = title,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    }
}