package dev.mexware.stresswatch.feature.sensors.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.mexware.stresswatch.R
import dev.mexware.stresswatch.feature.sensors.model.SensorCard
import dev.mexware.stresswatch.feature.sensors.model.SensorType
import dev.mexware.stresswatch.feature.sensors.model.events.SensorsEvent
import dev.mexware.stresswatch.feature.sensors.model.events.SensorsUiState

class SensorsViewModel : ViewModel() {

    var uiState by mutableStateOf(SensorsUiState())
        private set

    init {
        // Datos emulados (iconos: usa tus drawables reales)
        uiState = uiState.copy(
            cards = listOf(
                SensorCard(
                    type = SensorType.STRESS,
                    title = "Niveles de estrés",
                    description = "Consulta tus fluctuaciones recientes",
                    iconRes = R.drawable.logo_stress
                ),
                SensorCard(
                    type = SensorType.DREAM, // cambia a SLEEP si lo necesitas
                    title = "Nivel de actividad",
                    description = "Movimiento y energía diaria",
                    iconRes = R.drawable.logo_stress
                ),
                SensorCard(
                    type = SensorType.TEMPERATURE,
                    title = "Temperatura corporal",
                    description = "Variaciones que influyen en tu bienestar",
                    iconRes = R.drawable.logo_stress
                )
            )
        )
    }

    fun onEvent(e: SensorsEvent) {
        when (e) {
            SensorsEvent.Refresh -> { /* TODO: cargar desde repositorio/sensores */ }
            is SensorsEvent.CardClicked -> {
                // Aquí no navegamos directamente; la Screen decide qué hacer.
                // Si quieres emitir navegación como efecto, podemos exponer un Flow/Channel.
            }
        }
    }
}