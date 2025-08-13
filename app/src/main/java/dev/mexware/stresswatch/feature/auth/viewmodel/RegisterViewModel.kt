package dev.mexware.stresswatch.feature.auth.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.mexware.stresswatch.feature.auth.model.*
import dev.mexware.stresswatch.feature.auth.model.events.RegisterEvent
import dev.mexware.stresswatch.feature.auth.model.events.RegisterUiState

class RegisterViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var uiState by mutableStateOf(RegisterUiState())
        private set

    fun onEvent(e: RegisterEvent) {
        when (e) {
            // Antes avanzábamos de pantalla con este evento; ahora solo marca aceptado.
            is RegisterEvent.AcceptDisclaimer ->
                update { it.copy(disclaimerAccepted = true) }

            // NUEVO: toggle del checkbox de consentimiento
            is RegisterEvent.DisclaimerAcceptedChanged ->
                update { it.copy(disclaimerAccepted = e.accepted) }

            is RegisterEvent.NameChanged ->
                update { it.copy(data = it.data.copy(name = e.value)) }

            is RegisterEvent.GenderSelected ->
                update { it.copy(data = it.data.copy(gender = e.value)) }

            is RegisterEvent.BirthDateChanged ->
                update { it.copy(data = it.data.copy(birthDate = e.value)) }

            is RegisterEvent.CountryChanged ->
                update { it.copy(data = it.data.copy(country = e.value)) }

            is RegisterEvent.AvatarSelected ->
                update { it.copy(data = it.data.copy(avatarId = e.id)) }

            RegisterEvent.Next -> nextStep()
            RegisterEvent.Back -> prevStep()
            RegisterEvent.Submit -> submit()
        }
    }

    /* ---- Navegación interna de pasos ---- */

    private fun nextStep() {
        if (!uiState.isStepValid) return
        val next = when (uiState.step) {
            RegisterStep.DISCLAIMER -> RegisterStep.NAME
            RegisterStep.NAME -> RegisterStep.GENDER
            RegisterStep.GENDER -> RegisterStep.PROFILE
            RegisterStep.PROFILE -> RegisterStep.PROFILE
        }
        goTo(next)
    }

    private fun prevStep() {
        val prev = when (uiState.step) {
            RegisterStep.DISCLAIMER -> RegisterStep.DISCLAIMER
            RegisterStep.NAME -> RegisterStep.DISCLAIMER
            RegisterStep.GENDER -> RegisterStep.NAME
            RegisterStep.PROFILE -> RegisterStep.GENDER
        }
        goTo(prev)
    }

    private fun submit() {
        if (uiState.step != RegisterStep.PROFILE) return
        val validated = validate(uiState)
        if (!validated.isStepValid) {
            uiState = validated
            return
        }

        // Simulación de envío: aquí iría tu repositorio/UseCase (coroutine).
        uiState = uiState.copy(isSubmitting = true, submitError = null)
        // TODO: realizar la llamada real y manejar éxito/error.
        uiState = uiState.copy(isSubmitting = false)
    }

    /* ---- Utilidades de estado ---- */

    private fun update(f: (RegisterUiState) -> RegisterUiState) {
        uiState = f(uiState)
        uiState = validate(uiState) // revalida tras cada cambio
        persist()
    }

    private fun goTo(step: RegisterStep) {
        uiState = uiState.copy(step = step)
        uiState = validate(uiState)
        persist()
    }

    private fun persist() {
        // Guarda progreso mínimo (opcional).
        savedStateHandle["register_step"] = uiState.step.name
        savedStateHandle["register_name"] = uiState.data.name
        savedStateHandle["register_gender"] = uiState.data.gender?.name
        savedStateHandle["register_birth"] = uiState.data.birthDate
        savedStateHandle["register_country"] = uiState.data.country
        savedStateHandle["register_avatar"] = uiState.data.avatarId
        savedStateHandle["register_disclaimer"] = uiState.disclaimerAccepted
    }

    private fun validate(state: RegisterUiState): RegisterUiState {
        val errors = mutableMapOf<String, String>()
        val valid = when (state.step) {
            // Cambia: el paso 1 solo es válido si el checkbox está marcado
            RegisterStep.DISCLAIMER -> state.disclaimerAccepted

            RegisterStep.NAME -> {
                if (state.data.name.trim().length < 2) {
                    errors["name"] = "Ingresa un nombre válido."
                    false
                } else true
            }
            RegisterStep.GENDER -> {
                if (state.data.gender == null) {
                    errors["gender"] = "Selecciona un género."
                    false
                } else true
            }
            RegisterStep.PROFILE -> {
                var ok = true
                if (state.data.birthDate.isBlank()) {
                    errors["birthDate"] = "Ingresa tu fecha de nacimiento."
                    ok = false
                }
                if (state.data.country.isBlank()) {
                    errors["country"] = "Selecciona tu país de residencia."
                    ok = false
                }
                ok
            }
        }
        return state.copy(fieldErrors = errors, isStepValid = valid)
    }
}
