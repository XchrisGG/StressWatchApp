package dev.mexware.stresswatch.feature.auth.model.events

import dev.mexware.stresswatch.feature.auth.model.RegisterData
import dev.mexware.stresswatch.feature.auth.model.RegisterStep

/**
 * Única fuente de verdad para la UI del registro.
 */
data class RegisterUiState(
    val step: RegisterStep = RegisterStep.DISCLAIMER,
    val data: RegisterData = RegisterData(),

    // Errores por campo (clave sugerida: "name", "birthDate", "country", etc.)
    val fieldErrors: Map<String, String> = emptyMap(),

    // ¿El paso actual es válido? (habilita/deshabilita el botón Siguiente/Enviar)
    val isStepValid: Boolean = false,

    // Estado de envío final
    val isSubmitting: Boolean = false,
    val submitError: String? = null,

    // NUEVO: aceptación del disclaimer (habilita avanzar en el primer paso)
    val disclaimerAccepted: Boolean = false
)