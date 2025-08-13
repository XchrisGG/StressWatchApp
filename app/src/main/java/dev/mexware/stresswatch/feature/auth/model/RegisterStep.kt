package dev.mexware.stresswatch.feature.auth.model

enum class RegisterStep {
    DISCLAIMER, // Avisos “Recuerda que…”
    NAME,       // ¿Cómo te llamas?
    GENDER,     // Selecciona tu género
    PROFILE     // Avatar, fecha de nacimiento, país (último paso)
}
