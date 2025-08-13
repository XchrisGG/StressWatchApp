package dev.mexware.stresswatch.feature.home.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Tarjeta superior con saludo y avatar circular.
 * Colores estáticos para coincidir con tu estilo.
 */
@Composable
fun ProfileHeaderCard(
    name: String,
    avatarId: Int?, // por ahora no se usa; placeholder con inicial
    modifier: Modifier = Modifier
) {
    val bg = Color(0xFF5FBCA7)        // verde
    val textColor = Color(0xFF0D0D0D) // casi negro
    Surface(
        color = bg,
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Avatar placeholder con inicial
            Surface(
                color = Color(0xFFBFE6DC),
                shape = CircleShape,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = (name.trim().takeIf { it.isNotEmpty() }?.first()?.uppercase()
                            ?: "U"),
                        color = textColor,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Column(Modifier.weight(1f)) {
                Text(
                    text = "Hola ${name.ifBlank { "Usuario" }}",
                    color = textColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "Bienvenido a tu perfil",
                    color = textColor.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
            }
        }
    }
}