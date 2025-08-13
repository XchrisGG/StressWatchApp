package dev.mexware.stresswatch.feature.auth.model.events

import dev.mexware.stresswatch.feature.auth.model.Gender

/**
 * Eventos que la UI envía al ViewModel.
 */
sealed interface RegisterEvent {
 // (Opcional) ya no navegamos con este, pero lo dejo por compatibilidad:
 data object AcceptDisclaimer : RegisterEvent

 // NUEVO: marca/ desmarca el consentimiento del disclaimer
 data class DisclaimerAcceptedChanged(val accepted: Boolean) : RegisterEvent

 data class NameChanged(val value: String) : RegisterEvent
 data class GenderSelected(val value: Gender) : RegisterEvent
 data class BirthDateChanged(val value: String) : RegisterEvent
 data class CountryChanged(val value: String) : RegisterEvent
 data class AvatarSelected(val id: Int) : RegisterEvent

 data object Next : RegisterEvent
 data object Back : RegisterEvent
 data object Submit : RegisterEvent
}