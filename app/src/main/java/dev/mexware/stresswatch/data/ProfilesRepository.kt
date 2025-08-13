package dev.mexware.stresswatch.data

import dev.mexware.stresswatch.feature.home.model.events.HomeUiState
import dev.mexware.stresswatch.feature.sensors.model.SensorType
import dev.mexware.stresswatch.feature.sensors.model.events.SensorDetailUiState

interface ProfilesRepository {
    fun selectProfile(index: Int)
    fun currentHomeUiState(): HomeUiState
    fun sensorData(type: SensorType): SensorDetailUiState
}

