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
import dev.mexware.stresswatch.feature.auth.view.components.NameInputField
import dev.mexware.stresswatch.ui.theme.StressDarkBlue
import dev.mexware.stresswatch.ui.theme.StressGrayLight

@Composable
fun StepName(
    value: String,
    error: String?,
    onChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StressDarkBlue)
            .padding(horizontal = 24.dp, vertical = 80.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {

        Text(
            text = "¡Hola!",
            style = MaterialTheme.typography.headlineMedium,
            color = StressGrayLight,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "¿Cómo te llamas?",
            style = MaterialTheme.typography.titleMedium,
            color = StressGrayLight
        )

        NameInputField(
            value = value,
            onValueChange = onChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Christian",
            errorText = error
        )
    }
}