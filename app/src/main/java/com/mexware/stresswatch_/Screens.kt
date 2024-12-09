package com.mexware.stresswatch_

sealed class Screens (val name: String){
    object ChatScreen : Screens("Chat")
    object HomeScreen : Screens("Home")
    object LoginRegisterScreen : Screens("LoginRegister")
    object LoginScreen : Screens("Login")
    object LogoScreen : Screens("Logo")
    object RegisterScreen : Screens("Register")
    object UserScreen : Screens("User")

}