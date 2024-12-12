package com.mexware.stresswatch_.models

import java.util.Date

// Definición de un enum para el sexo
enum class Sexo {
    Masculino,
    Femenino,
    No_especificar
}

// Data class que representa un modelo de usuario
data class UserModel(
    val nombres: String,
    val apellidos: String,
    val edad: Int,
    val sexo: Sexo,
    val fechaNacimiento: Date,
    val pais: String,
    val email: String,
    val password: String
)