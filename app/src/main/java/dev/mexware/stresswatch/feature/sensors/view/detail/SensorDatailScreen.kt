package dev.mexware.stresswatch.feature.sensors.view.detail


import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.mexware.stresswatch.feature.sensors.model.SensorType
import dev.mexware.stresswatch.feature.sensors.view.components.MetricStat
import dev.mexware.stresswatch.feature.sensors.view.components.SensorLineChart
import dev.mexware.stresswatch.feature.sensors.viewmodel.SensorDetailViewModel

@Composable
fun SensorDetailScreen(
    type: SensorType,
    vm: SensorDetailViewModel = viewModel()
) {
    val bg = Color(0xFF0B2D46)
    LaunchedEffect(type) { vm.load(type) }
    val state = vm.uiState ?: return

    val avg = state.points.map { it.value }.average().toInt()
    val max = state.points.maxOf { it.value }.toInt()

    Surface(color = bg, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = when (type) {
                    SensorType.SLEEP -> "Nivel de sueño"
                    SensorType.STRESS -> "Nivel de estrés"
                    SensorType.MOOD -> "Estado de ánimo"
                },
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold
            )

            SensorLineChart(points = state.points)

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                MetricStat(
                    title = state.summary.totalLabel,
                    value = state.summary.totalValue,
                    modifier = Modifier.weight(1f)
                )
                MetricStat(
                    title = "Promedio",
                    value = "${avg}%",
                    modifier = Modifier.weight(1f)
                )
                MetricStat(
                    title = "Máximo",
                    value = "${max}%",
                    modifier = Modifier.weight(1f)
                )
            }

            Text(
                text = state.summary.note,
                color = Color.White.copy(alpha = 0.85f)
            )
        }
    }
}