package dev.mexware.stresswatch.feature.auth.model.events

sealed interface LoginEvent{
    data class OnEmailChanged(val value: String) :LoginEvent
    data class OnPasswordChanged(val value: String) :LoginEvent
    data object TogglePasswordVisibility : LoginEvent
    data object Submit : LoginEvent
    data object ClearError : LoginEvent


}
