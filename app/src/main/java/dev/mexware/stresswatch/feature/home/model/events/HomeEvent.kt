package dev.mexware.stresswatch.feature.home.model.events

sealed interface HomeEvent {
    data object Refresh : HomeEvent
    data object EditProfile : HomeEvent
}
