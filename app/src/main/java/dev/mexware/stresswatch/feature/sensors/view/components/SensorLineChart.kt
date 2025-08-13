package dev.mexware.stresswatch.feature.sensors.view.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        .height(200.dp),
    bg: Color = Color(0xFF0E3A5A),
    line: Color = Color(0xFF5FBCA7),
    grid: Color = Color(0x33FFFFFF)
) {
    Canvas(modifier = modifier.background(bg).padding(horizontal = 8.dp, vertical = 6.dp)) {
        val w = size.width
        val labelSpace = 20.dp.toPx()
        val chartH = size.height - labelSpace

        // Grid horizontal (4 líneas)
        val rows = 4
        val stepY = chartH / rows
        repeat(rows + 1) { i ->
            val y = i * stepY
            drawLine(color = grid, start = Offset(0f, y), end = Offset(w, y), strokeWidth = 1f)
        }

        if (points.isEmpty()) return@Canvas

        val stepX = if (points.size <= 1) w else w / (points.size - 1)

        // Grid vertical
        repeat(points.size) { i ->
            val x = i * stepX
            drawLine(color = grid, start = Offset(x, 0f), end = Offset(x, chartH), strokeWidth = 1f)
        }

        val maxV = max(points.maxOf { it.value }, 1f)

        val path = Path()
        val fill = Path()
        points.forEachIndexed { i, p ->
            val x = i * stepX
            val y = chartH - (p.value / maxV) * chartH
            if (i == 0) {
                path.moveTo(x, y)
                fill.moveTo(x, chartH)
                fill.lineTo(x, y)
            } else {
                path.lineTo(x, y)
                fill.lineTo(x, y)
            }
        }
        fill.lineTo((points.size - 1) * stepX, chartH)
        fill.close()
        drawPath(
            fill,
            brush = Brush.verticalGradient(listOf(line.copy(alpha = 0.4f), Color.Transparent))
        )
        drawPath(path, color = line, strokeWidth = 4f)

        val labelPaint = Paint().apply {
            color = Color.White.toArgb()
            textAlign = Paint.Align.CENTER
            textSize = 12.sp.toPx()
        }
        val valuePaint = Paint().apply {
            color = Color.White.toArgb()
            textAlign = Paint.Align.CENTER
            textSize = 10.sp.toPx()
        }

        points.forEachIndexed { i, p ->
            val x = i * stepX
            val y = chartH - (p.value / maxV) * chartH
            drawCircle(color = line, radius = 4.dp.toPx(), center = Offset(x, y))
            drawContext.canvas.nativeCanvas.drawText(p.label, x, size.height - 4.dp.toPx(), labelPaint)
            drawContext.canvas.nativeCanvas.drawText(p.value.toInt().toString(), x, y - 8.dp.toPx(), valuePaint)
        }
    }
}