package dev.mexware.stresswatch.feature.chat.model

enum class Sender { BOT, USER }

data class ChatMessage(
    val id: Long,
    val text: String,
    val sender: Sender
)