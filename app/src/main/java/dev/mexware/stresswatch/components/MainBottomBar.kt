package dev.mexware.stresswatch.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mexware.stresswatch.feature.main.model.MainDestination
import dev.mexware.stresswatch.ui.theme.StressMint

/**
 * BottomBar con estilo fijo (colores estáticos).
 * Usa íconos de Material (no requiere drawables).
 */
@Composable
fun MainBottomBar(
    currentRoute: String?,
    onSelect: (MainDestination) -> Unit
) {
    // barra
    val circleColor = Color(0xFFBFE6DC)   // círculo del icono
    val textColor = Color(0xFF0D0D0D)     // texto

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(StressMint)
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val items = listOf(MainDestination.HOME, MainDestination.CHAT, MainDestination.SENSORS)

        items.forEach { dest ->
            val selected = currentRoute == dest.route
            Column(
                modifier = Modifier
                    .width(80.dp)
                    .clickable { onSelect(dest) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    shape = CircleShape,
                    color = circleColor,
                    modifier = Modifier.size(36.dp)
                ) {
                    val icon = when (dest) {
                        MainDestination.HOME -> Icons.Filled.Home
                        MainDestination.CHAT -> Icons.Filled.Chat
                        MainDestination.SENSORS -> Icons.Filled.Sensors // requiere material-icons-extended
                    }
                    Box(contentAlignment = Alignment.Center) {
                        Icon(imageVector = icon, contentDescription = dest.label, tint = textColor)
                    }
                }
                Spacer(Modifier.height(4.dp))
                Text(text = dest.label, color = textColor, fontSize = 12.sp)
            }
        }
    }
}