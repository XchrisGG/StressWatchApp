package dev.mexware.stresswatch.components.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

/**
 * Hace que cualquier Composable sea clickeable pero sin efecto ripple.
 * Útil para enlaces de texto o elementos que no deberían mostrar animación visual.
 */
@Composable
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier =
    this.then(
        Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        )
    )
