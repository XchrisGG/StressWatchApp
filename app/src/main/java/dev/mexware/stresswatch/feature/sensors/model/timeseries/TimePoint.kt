package dev.mexware.stresswatch.feature.sensors.model.timeseries

data class TimePoint(
    val label: String,   // p.ej. "L", "M", "X", "J", "V", "S", "D"
    val value: Float     // 0..100 (porcentaje) u otra escala normalizada
)