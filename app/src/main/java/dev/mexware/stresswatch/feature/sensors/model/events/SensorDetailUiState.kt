package dev.mexware.stresswatch.feature.sensors.model.events

import dev.mexware.stresswatch.feature.sensors.model.SensorType
import dev.mexware.stresswatch.feature.sensors.model.timeseries.TimePoint
import dev.mexware.stresswatch.feature.sensors.model.timeseries.Summary

data class SensorDetailUiState(
    val type: SensorType,
    val points: List<TimePoint> = emptyList(),
    val summary: Summary = Summary(),
    val isLoading: Boolean = false,
    val error: String? = null
)