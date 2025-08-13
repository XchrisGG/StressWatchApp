package dev.mexware.stresswatch.feature.main.model
enum class MainDestination(val route: String, val label: String) {
    HOME("home", "Inicio"),
    CHAT("chat", "Chat"),
    SENSORS("sensors", "Sensores");
}