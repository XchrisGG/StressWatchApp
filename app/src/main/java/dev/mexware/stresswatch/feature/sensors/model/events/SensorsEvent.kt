package dev.mexware.stresswatch.feature.sensors.model.events

import dev.mexware.stresswatch.feature.sensors.model.SensorType

sealed interface SensorsEvent {
    data object Refresh : SensorsEvent
    data class CardClicked(val type: SensorType) : SensorsEvent
}