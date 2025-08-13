package dev.mexware.stresswatch.feature.home.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.mexware.stresswatch.feature.home.view.components.ProfileHeaderCard
import dev.mexware.stresswatch.feature.home.view.components.ProfileInfoCard
import dev.mexware.stresswatch.feature.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    userName: String,                // viene desde MainScreen
    vm: HomeViewModel = viewModel()
) {
    // Inyecta el nombre recibido (si cambia, actualiza)
    androidx.compose.runtime.LaunchedEffect(userName) {
        if (userName.isNotBlank()) vm.setName(userName)
    }

    val state = vm.uiState
    val background = Color(0xFF0B2D46) // azul fondo

    Surface(color = background, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProfileHeaderCard(
                name = state.name,
                avatarId = state.avatarId,
                modifier = Modifier.fillMaxWidth()
            )

            ProfileInfoCard(
                name = state.name.ifBlank { "—" },
                genderText = when (state.gender) {
                    dev.mexware.stresswatch.feature.auth.model.Gender.FEMALE -> "Femenino"
                    dev.mexware.stresswatch.feature.auth.model.Gender.MALE -> "Masculino"
                    null -> "—"
                },
                birthDate = state.birthDate.ifBlank { "—" },
                country = state.country.ifBlank { "—" },
                modifier = Modifier.fillMaxWidth()
            )

            // Aquí podrás agregar botones para "Personalizar perfil", "Ajustes", etc.
            // Ej: PrimaryButton("Personalizar") { /* nav a HomeRoute.Personalize */ }
        }
    }
}