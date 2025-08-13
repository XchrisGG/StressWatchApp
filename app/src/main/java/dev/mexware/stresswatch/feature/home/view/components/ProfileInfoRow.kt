package dev.mexware.stresswatch.feature.home.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileInfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    val labelColor = Color(0xFFBFE6DC) // verde claro para label
    val valueColor = Color(0xFFFFFFFF) // blanco para valor
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = labelColor, fontSize = 14.sp)
        Text(text = value, color = valueColor, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}