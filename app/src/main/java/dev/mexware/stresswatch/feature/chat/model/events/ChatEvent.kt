package dev.mexware.stresswatch.feature.chat.model.events

sealed interface ChatEvent {
    data class InputChanged(val value: String) : ChatEvent
    data object SendPressed : ChatEvent
    // Para futuro: data class Received(val text: String) : ChatEvent
}