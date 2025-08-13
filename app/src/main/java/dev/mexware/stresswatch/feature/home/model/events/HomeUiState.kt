package dev.mexware.stresswatch.feature.home.model.events

import dev.mexware.stresswatch.feature.auth.model.Gender

data class HomeUiState(
    val name: String = "",
    val gender: Gender? = null,
    val birthDate: String = "",
    val country: String = "",
    val avatarId: Int? = null,

    val isLoading: Boolean = false,
    val error: String? = null
)