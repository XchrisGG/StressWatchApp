package dev.mexware.stresswatch.feature.auth.model

data class LoginUiState(
    val email: String = ",",
    val password: String = "",
    val isPasswordVisible: Boolean = false,

    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,

    val emailError: String? = null,
    val passwordError: String? = null,
    val loginError: String? = null,


)
