package dev.mexware.stresswatch.feature.auth.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.mexware.stresswatch.data.ProfilesRepository
import dev.mexware.stresswatch.data.SampleProfilesRepository
import dev.mexware.stresswatch.feature.auth.model.LoginUiState
import dev.mexware.stresswatch.feature.auth.model.events.LoginEvent

class LoginViewModel(
    private val profilesRepository: ProfilesRepository = SampleProfilesRepository
) : ViewModel() {

    /**
     * Estado observable por Compose. Cada asignación a `uiState` provoca recomposición.
     */
    var uiState by mutableStateOf(LoginUiState())
        private set

    /**
     * Helper para actualizar el estado de forma inmutable y segura.
     */
    private fun setState(reducer: (LoginUiState) -> LoginUiState) {
        uiState = reducer(uiState)
    }

    /**
     * Único punto de entrada desde la UI.
     * La vista emite eventos y el ViewModel decide qué hacer.
     */
    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnEmailChanged -> setState {
                it.copy(email = event.value, emailError = null, loginError = null)
            }
            is LoginEvent.OnPasswordChanged -> setState {
                it.copy(password = event.value, passwordError = null, loginError = null)
            }
            LoginEvent.TogglePasswordVisibility -> setState {
                it.copy(isPasswordVisible = !it.isPasswordVisible)
            }
            LoginEvent.ClearError -> setState { it.copy(loginError = null) }
            LoginEvent.Submit -> submit()
        }
    }

    /**
     * Orquestación del login:
     * 1) Validar campos
     * 2) Intentar login contra el repositorio
     * 3) Actualizar estado con éxito / error
     */
    private fun submit() {
        val email = uiState.email.trim()
        val password = uiState.password

        var hasError = false
        if (email.isBlank()) {
            setState { it.copy(emailError = "Ingresa tu correo") }
            hasError = true
        }
        if (password.isBlank()) {
            setState { it.copy(passwordError = "Ingresa tu contraseña") }
            hasError = true
        }
        if (hasError) return

        setState { it.copy(isLoading = true) }
        val success = profilesRepository.login(email, password)
        setState {
            it.copy(
                isLoading = false,
                isLoggedIn = success,
                loginError = if (success) null else "Usuario o contraseña incorrectos"
            )
        }
    }
}
