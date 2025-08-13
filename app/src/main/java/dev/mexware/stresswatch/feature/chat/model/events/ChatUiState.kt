package dev.mexware.stresswatch.feature.chat.model.events

import dev.mexware.stresswatch.feature.chat.model.ChatMessage

data class ChatUiState(
    val messages: List<ChatMessage> = emptyList(),
    val input: String = "",
    val isSending: Boolean = false,
    val error: String? = null
)