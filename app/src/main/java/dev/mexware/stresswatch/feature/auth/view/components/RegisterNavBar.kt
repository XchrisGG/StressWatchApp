package dev.mexware.stresswatch.feature.auth.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import dev.mexware.stresswatch.ui.theme.StressMint

/**
 * Barra inferior común del flujo de registro.
 *
 * - Flecha (izquierda): volver al paso anterior.
 * - Botón "Siguiente": avanzar al siguiente paso.
 *
 * Mantén la lógica de cuándo habilitar/deshabilitar desde el ViewModel
 * (isStepValid, isSubmitting, etc.) para no mezclar reglas en la UI.
 */
@Composable
fun RegisterNavBar(
    onBack: () -> Unit,
    onNext: () -> Unit,
    canGoBack: Boolean,
    canGoNext: Boolean,
    isBusy: Boolean = false,
    nextText: String = "Siguiente"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(StressMint)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Botón redondo con flecha (volver)
        FilledTonalIconButton(
            onClick = onBack,
            enabled = canGoBack && !isBusy,
            colors = IconButtonDefaults.filledIconButtonColors(
            )

        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Atrás"
            )
        }

        // Botón principal (siguiente)
        ElevatedButton(
            onClick = onNext,
            enabled = canGoNext && !isBusy
        ) {
            Text(text = nextText)
        }
    }
}
