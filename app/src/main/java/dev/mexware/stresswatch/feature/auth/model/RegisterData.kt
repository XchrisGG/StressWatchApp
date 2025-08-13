package dev.mexware.stresswatch.feature.auth.model

/**
 * Datos acumulados durante el flujo de registro.
 * Usa tipos simples (String/Int) para evitar dependencias extra.
 * Si luego deseas LocalDate u objectos más ricos, podemos migrar.
 */
data class RegisterData(
    val name: String = "",
    val gender: Gender? = null,
    val birthDate: String = "", // formato libre (ej. "DD/MM/AAAA")
    val country: String = "",
    val avatarId: Int? = null
)
