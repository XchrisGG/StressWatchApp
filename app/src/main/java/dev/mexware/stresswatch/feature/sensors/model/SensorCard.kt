package dev.mexware.stresswatch.feature.sensors.model

import androidx.annotation.DrawableRes

data class SensorCard(
    val type: SensorType,
    val title: String,
    val description: String,
    @DrawableRes val iconRes: Int
)