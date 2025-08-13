package dev.mexware.stresswatch.feature.sensors.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.mexware.stresswatch.feature.sensors.model.SensorType
import dev.mexware.stresswatch.feature.sensors.model.events.SensorsEvent
import dev.mexware.stresswatch.feature.sensors.view.components.SensorInfoCard
import dev.mexware.stresswatch.feature.sensors.view.components.SensorsSectionHeader
import dev.mexware.stresswatch.feature.sensors.viewmodel.SensorsViewModel

@Composable
fun SensorsDashboardScreen(
    onOpen: (SensorType) -> Unit,   // navegación delegada
    vm: SensorsViewModel = viewModel()
) {
    val screenBg = Color(0xFF0B2D46)

    Surface(color = screenBg, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SensorsSectionHeader("Monitoreo de estrés")
            vm.uiState.cards.firstOrNull { it.type == SensorType.STRESS }?.let { card ->
                SensorInfoCard(
                    title = card.title,
                    description = card.description,
                    iconRes = card.iconRes,
                    onClick = {
                        vm.onEvent(SensorsEvent.CardClicked(SensorType.STRESS))
                        onOpen(SensorType.STRESS)
                    }
                )
            }

            SensorsSectionHeader("Actividad física")
            vm.uiState.cards.firstOrNull { it.type == SensorType.DREAM }?.let { card ->
                SensorInfoCard(
                    title = card.title,
                    description = card.description,
                    iconRes = card.iconRes,
                    onClick = {
                        vm.onEvent(SensorsEvent.CardClicked(SensorType.DREAM))
                        onOpen(SensorType.DREAM)
                    }
                )
            }

            SensorsSectionHeader("Estado del animo")
            vm.uiState.cards.firstOrNull { it.type == SensorType.TEMPERATURE }?.let { card ->
                SensorInfoCard(
                    title = card.title,
                    description = card.description,
                    iconRes = card.iconRes,
                    onClick = {
                        vm.onEvent(SensorsEvent.CardClicked(SensorType.TEMPERATURE))
                        onOpen(SensorType.TEMPERATURE)
                    }
                )
            }
        }
    }
}