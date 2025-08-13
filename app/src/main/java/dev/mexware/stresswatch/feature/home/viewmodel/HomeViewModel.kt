package dev.mexware.stresswatch.feature.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.mexware.stresswatch.feature.auth.model.Gender
import dev.mexware.stresswatch.feature.home.model.events.HomeEvent
import dev.mexware.stresswatch.feature.home.model.events.HomeUiState

class HomeViewModel : ViewModel() {

    var uiState by mutableStateOf(
        HomeUiState(
            // Datos emulados (se sustituyen cuando conectes tu repo/sesión)
            name = "Christian",
            gender = Gender.MALE,
            birthDate = "01/01/1998",
            country = "México",
            avatarId = 1
        )
    )
        private set

    fun onEvent(e: HomeEvent) {
        when (e) {
            HomeEvent.Refresh -> { /* TODO: cargar perfil real */ }
            HomeEvent.EditProfile -> { /* TODO: navegación/acción editar */ }
        }
    }

    /** Permite inyectar el nombre desde MainScreen si lo pasas por parámetro */
    fun setName(name: String) {
        uiState = uiState.copy(name = name)
    }
}