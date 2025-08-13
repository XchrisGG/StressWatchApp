package dev.mexware.stresswatch.feature.sensors.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.mexware.stresswatch.data.ProfilesRepository
import dev.mexware.stresswatch.data.SampleProfilesRepository
import dev.mexware.stresswatch.feature.sensors.model.SensorType
import dev.mexware.stresswatch.feature.sensors.model.events.SensorDetailEvent
import dev.mexware.stresswatch.feature.sensors.model.events.SensorDetailUiState

class SensorDetailViewModel(
    private val profilesRepository: ProfilesRepository = SampleProfilesRepository
) : ViewModel() {

    var uiState by mutableStateOf<SensorDetailUiState?>(null)
        private set

    fun load(type: SensorType) {
        uiState = profilesRepository.sensorData(type)
    }

    fun onEvent(e: SensorDetailEvent) {
        when (e) {
            SensorDetailEvent.Refresh -> uiState?.let { load(it.type) }
        }
    }
}
