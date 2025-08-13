package dev.mexware.stresswatch.feature.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.mexware.stresswatch.data.ProfilesRepository
import dev.mexware.stresswatch.data.SampleProfilesRepository
import dev.mexware.stresswatch.feature.home.model.events.HomeEvent
import dev.mexware.stresswatch.feature.home.model.events.HomeUiState

class HomeViewModel(
    private val profilesRepository: ProfilesRepository = SampleProfilesRepository
) : ViewModel() {

    var uiState by mutableStateOf(profilesRepository.currentHomeUiState())
        private set

    fun onEvent(e: HomeEvent) {
        when (e) {
            HomeEvent.Refresh -> { /* TODO: cargar perfil real */ }
            HomeEvent.EditProfile -> { /* TODO: navegación/acción editar */ }
        }
    }

}