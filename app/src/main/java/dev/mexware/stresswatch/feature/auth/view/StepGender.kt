package dev.mexware.stresswatch.feature.auth.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.mexware.stresswatch.feature.auth.model.Gender
import dev.mexware.stresswatch.feature.auth.view.components.GenderPillButton
import dev.mexware.stresswatch.ui.theme.StressDarkBlue
import dev.mexware.stresswatch.ui.theme.StressGrayLight

@Composable
fun StepGender(
    selected: Gender?,
    name: String,
    error: String?,
    onSelect: (Gender) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()                 // 1) ocupa toda la pantalla
            .background(StressDarkBlue)    // 2) pinta el fondo en toda el área
            .padding(horizontal = 24.dp, vertical = 50.dp), // 3) padding interno
        verticalArrangement = Arrangement.spacedBy(60.dp)
    ) {
        // Títulos como en Figma
        Text(
            text = "Hola ${name.ifBlank { "Usuario" }}",
            style = MaterialTheme.typography.headlineMedium,
            color = StressGrayLight,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Selecciona tu género",
            style = MaterialTheme.typography.titleMedium,
            color = StressGrayLight
        )

        // Botones "píldora"
        GenderPillButton(
            label = "Femenino (Ella)",
            selected = selected == Gender.FEMALE,
            onClick = { onSelect(Gender.FEMALE) },
            modifier = Modifier.fillMaxWidth()
        )

        GenderPillButton(
            label = "Masculino (Él)",
            selected = selected == Gender.MALE,
            onClick = { onSelect(Gender.MALE) },
            modifier = Modifier.fillMaxWidth()
        )

        if (!error.isNullOrBlank()) {
            Text(
                text = error,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}