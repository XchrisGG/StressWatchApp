package dev.mexware.stresswatch.feature.sensors.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.mexware.stresswatch.feature.sensors.model.SensorType
import dev.mexware.stresswatch.feature.sensors.model.events.SensorDetailEvent
import dev.mexware.stresswatch.feature.sensors.model.events.SensorDetailUiState
import dev.mexware.stresswatch.feature.sensors.model.timeseries.Summary
import dev.mexware.stresswatch.feature.sensors.model.timeseries.TimePoint
import kotlin.random.Random

class SensorDetailViewModel : ViewModel() {

    var uiState by mutableStateOf<SensorDetailUiState?>(null)
        private set

    fun load(type: SensorType) {
        // Datos mock: 7 puntos (semana)
        val labels = listOf("L", "M", "X", "J", "V", "S", "D")
        val bounds = when (type) {
            SensorType.SLEEP -> 60..95      // %
            SensorType.STRESS -> 15..85     // índice %
            SensorType.MOOD -> 40..90       // % “ánimo”
        }
        val pts = labels.map { l ->
            val v = Random.nextInt(bounds.first, bounds.last).toFloat()
            TimePoint(label = l, value = v)
        }

        val current = pts.last().value
        val summary = when (type) {
            SensorType.SLEEP -> Summary(
                totalLabel = "Sueño total",
                totalValue = "${current.toInt()}%",
                note = if (current >= 75f) "Buen descanso esta semana"
                else "Intenta mejorar tu rutina nocturna"
            )
            SensorType.STRESS -> Summary(
                totalLabel = "Estrés actual",
                totalValue = "${current.toInt()}%",
                note = when {
                    current < 40f -> "Estrés bajo"
                    current < 70f -> "Estrés moderado"
                    else -> "Estrés alto"
                }
            )
            SensorType.MOOD -> Summary(
                totalLabel = "Ánimo actual",
                totalValue = "${current.toInt()}%",
                note = if (current >= 60f) "Mejor que la semana pasada"
                else "Podrías intentar una sesión de respiración"
            )
        }

        uiState = SensorDetailUiState(type = type, points = pts, summary = summary)
    }

    fun onEvent(e: SensorDetailEvent) {
        when (e) {
            SensorDetailEvent.Refresh -> uiState?.let { load(it.type) }
        }
    }
}