package dev.mexware.stresswatch.feature.chat.view.components

import androidx.compose.foundation.background
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
import dev.mexware.stresswatch.feature.chat.model.ChatMessage
import dev.mexware.stresswatch.feature.chat.model.Sender

/**
 * Burbuja con estilo del Figma:
 * - Bot: alineado a la izquierda, fondo verde pastel y avatar circular.
 * - User: alineado a la derecha, fondo azul claro.
 * Colores estáticos.
 */
@Composable
fun ChatMessageBubble(
    message: ChatMessage,
    modifier: Modifier = Modifier
) {
    val isBot = message.sender == Sender.BOT
    val botBubble = Color(0xFF5FBCA7)      // verde pastel
    val userBubble = Color(0xFFCFE8F3)     // azul claro
    val textColor = Color(0xFF0D0D0D)

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = if (isBot) Arrangement.Start else Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ) {
        if (isBot) {
            // Avatar redondo con emoji 🤖 (evita requerir drawables/íconos extra)
            Surface(
                color = Color(0xFFBFE6DC),
                shape = CircleShape,
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 8.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text("🤖", fontSize = 18.sp)
                }
            }
        }

        Surface(
            color = if (isBot) botBubble else userBubble,
            shape = RoundedCornerShape(18.dp),
            modifier = Modifier.widthIn(min = 80.dp, max = 280.dp)
        ) {
            Text(
                text = message.text,
                color = textColor,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
            )
        }
    }
}