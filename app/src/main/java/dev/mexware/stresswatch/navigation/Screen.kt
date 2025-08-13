package dev.mexware.stresswatch.navigation

sealed class Screen (val name: String){
    object LogoScreen : Screen("logo")
    object LoginScreen : Screen("login")
}