package dev.mexware.stresswatch.feature.chat.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.mexware.stresswatch.feature.chat.model.ChatMessage
import dev.mexware.stresswatch.feature.chat.model.Sender
import dev.mexware.stresswatch.feature.chat.model.events.ChatEvent
import dev.mexware.stresswatch.feature.chat.model.events.ChatUiState

class ChatViewModel : ViewModel() {

    var uiState by mutableStateOf(
        ChatUiState(
            messages = listOf(
                ChatMessage(
                    id = 1L,
                    text = "Hola, bienvenido, soy tu Asistente personalizado, recuerda que no buscamos sustituir atención profesional, sino ser un complemento que te ayudará a través del viaje.",
                    sender = Sender.BOT
                )
            )
        )
    )
        private set

    fun onEvent(e: ChatEvent) {
        when (e) {
            is ChatEvent.InputChanged ->
                uiState = uiState.copy(input = e.value)

            ChatEvent.SendPressed -> send()
        }
    }

    private fun send() {
        val text = uiState.input.trim()
        if (text.isEmpty() || uiState.isSending) return

        val userMsg = ChatMessage(id = System.currentTimeMillis(), text = text, sender = Sender.USER)

        // Añadimos el mensaje del usuario y limpiamos input
        uiState = uiState.copy(
            messages = uiState.messages + userMsg,
            input = "",
            isSending = false
        )

        // (Opcional) Respuesta mock del bot
        val botMsg = ChatMessage(
            id = System.currentTimeMillis() + 1,
            text = "¡Gracias por tu mensaje! Pronto te responderé 😊",
            sender = Sender.BOT
        )
        uiState = uiState.copy(messages = uiState.messages + botMsg)
    }
}