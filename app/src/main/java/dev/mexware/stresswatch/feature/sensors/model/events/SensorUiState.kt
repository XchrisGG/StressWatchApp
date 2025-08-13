package dev.mexware.stresswatch.feature.sensors.model.events


import dev.mexware.stresswatch.feature.sensors.model.SensorCard

data class SensorsUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val cards: List<SensorCard> = emptyList()
)