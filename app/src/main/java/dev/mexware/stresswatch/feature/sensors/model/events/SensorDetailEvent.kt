package dev.mexware.stresswatch.feature.sensors.model.events

sealed interface SensorDetailEvent {
    data object Refresh : SensorDetailEvent
}