package dev.mexware.stresswatch.feature.chat.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.mexware.stresswatch.feature.chat.model.events.ChatEvent
import dev.mexware.stresswatch.feature.chat.viewmodel.ChatViewModel
import dev.mexware.stresswatch.feature.chat.view.components.ChatInputBar
import dev.mexware.stresswatch.feature.chat.view.components.ChatMessageBubble
import dev.mexware.stresswatch.feature.chat.view.components.ChatWelcomeHeader

@Composable
fun ChatScreen(
    vm: ChatViewModel = viewModel()
) {
    val state = vm.uiState
    val bg = Color(0xFF0B2D46) // azul oscuro general

    val listState = rememberLazyListState()
    LaunchedEffect(state.messages.size) {
        // autoscroll al último mensaje
        if (state.messages.isNotEmpty())
            listState.animateScrollToItem(state.messages.lastIndex)
    }

    Surface(color = bg, modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            ChatWelcomeHeader()

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                state = listState,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.messages, key = { it.id }) { msg ->
                    ChatMessageBubble(message = msg)
                }
            }

            ChatInputBar(
                value = state.input,
                onValueChange = { vm.onEvent(ChatEvent.InputChanged(it)) },
                onSend = { vm.onEvent(ChatEvent.SendPressed) },
                enabled = state.input.isNotBlank() && !state.isSending
            )
        }
    }
}