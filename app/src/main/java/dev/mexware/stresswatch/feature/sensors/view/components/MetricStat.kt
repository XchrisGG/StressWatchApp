package dev.mexware.stresswatch.feature.sensors.view.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MetricStat(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    val bg = Color(0xFF5FBCA7)
    val text = Color(0xFF0D0D0D)
    Surface(color = bg, shape = RoundedCornerShape(14.dp), modifier = modifier) {
        Column(Modifier.padding(horizontal = 14.dp, vertical = 10.dp)) {
            Text(title, color = text.copy(alpha = 0.9f), fontSize = 12.sp)
            Text(value, color = text, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}