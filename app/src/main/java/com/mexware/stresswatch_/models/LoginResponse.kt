package com.mexware.stresswatch_.models

import java.util.Date

data class LoginResponse(
    val message: String,
    val token: String?, // Token si el inicio de sesión es exitoso
    val user: UserModel? // Datos del usuario si el login tiene éxito
)