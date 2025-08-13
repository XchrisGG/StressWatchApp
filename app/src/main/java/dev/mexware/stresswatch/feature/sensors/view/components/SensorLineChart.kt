package dev.mexware.stresswatch.feature.sensors.view.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import dev.mexware.stresswatch.feature.sensors.model.timeseries.TimePoint
import kotlin.math.max

/**
 * Gráfico lineal simple (Canvas) para mock UI.
 * Colores estáticos; sin dependencias extra.
 */
@Composable
fun SensorLineChart(
    points: List<TimePoint>,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(180.dp),
    bg: Color = Color(0xFF0E3A5A),
    line: Color = Color(0xFF5FBCA7),
    grid: Color = Color(0x33FFFFFF)
) {
    Canvas(modifier = modifier.background(bg).padding(horizontal = 8.dp, vertical = 6.dp)) {
        val w = size.width
        val h = size.height

        // Grid horizontal (4 líneas)
        val rows = 4
        val stepY = h / rows
        repeat(rows + 1) { i ->
            val y = i * stepY
            drawLine(color = grid, start = Offset(0f, y), end = Offset(w, y), strokeWidth = 1f)
        }

        if (points.isEmpty()) return@Canvas

        val stepX = if (points.size <= 1) w else w / (points.size - 1)
        val maxV = max(points.maxOf { it.value }, 1f)

        val path = Path()
        points.forEachIndexed { i, p ->
            val x = i * stepX
            val y = h - (p.value / maxV) * h
            if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }
        drawPath(path, color = line)

        // Puntos
        points.forEachIndexed { i, p ->
            val x = i * stepX
            val y = h - (p.value / maxV) * h
            drawCircle(color = line, radius = 4.dp.toPx(), center = Offset(x, y))
        }
    }
}