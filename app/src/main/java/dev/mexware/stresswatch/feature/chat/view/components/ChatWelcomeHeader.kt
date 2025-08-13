package dev.mexware.stresswatch.feature.chat.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatWelcomeHeader() {
    Column(Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 12.dp)) {
        Divider(color = Color(0xFFE0E0E0).copy(alpha = 0.4f))
        Text(
            text = "Bienvenido a tu\nasistente personalizado",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 26.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}