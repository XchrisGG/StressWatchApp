package com.mexware.stresswatch_.ViewModels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mexware.stresswatch_.connection.ConnectionExpress
import com.mexware.stresswatch_.models.LoginRequest
import com.mexware.stresswatch_.models.Sexo
import com.mexware.stresswatch_.models.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val _userData = MutableStateFlow<List<UserModel>>(emptyList())
    val userData: StateFlow<List<UserModel>> = _userData.asStateFlow()

    var nombres by mutableStateOf("")
    var apellidos by mutableStateOf("")
    var edad by mutableStateOf(0)
    var sexo by mutableStateOf(Sexo.No_especificar)
    var fechaNacimiento by mutableStateOf(Date())
    var pais by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun fetchUserData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = ConnectionExpress.apiService.getUserData()
                _userData.value = response
                println("Usuarios obtenidos: $response")  // Agrega un log para verificar los datos
            } catch (exception: Exception) {
                _userData.value = emptyList()
                exception.printStackTrace()
                println("Error al obtener usuarios: ${exception.localizedMessage}")  // Agregar log de error
            }
        }
    }
    fun insertUser() {
        val user = UserModel(
            nombres = nombres,
            apellidos = apellidos,
            edad = edad,
            sexo = sexo,
            fechaNacimiento = fechaNacimiento,
            pais = pais,
            email = email,
            password = password
        )

        viewModelScope.launch(Dispatchers.IO) {
            try {
                ConnectionExpress.apiService.insertUser(user)
                println("Usuario insertado exitosamente")
            } catch (e: Exception) {
                e.printStackTrace()
                println("Error al registrar usuario: ${e.localizedMessage}")
                Log.d("UserViewModel", "Enviando usuario: $user")

            }
        }
    }
    fun login(onLoginResult: (Boolean, String?) -> Unit) {
        val loginRequest = LoginRequest(
            email = email,
            password = password
        )

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = ConnectionExpress.apiService.login(loginRequest)
                viewModelScope.launch(Dispatchers.Main) {
                    if (response.token != null) {
                        println("Inicio de sesión exitoso: ${response.message}")
                        onLoginResult(true, response.token)
                    } else {
                        println("Error de inicio de sesión: ${response.message}")
                        onLoginResult(false, response.message)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                println("Error al realizar la solicitud de inicio de sesión: ${e.localizedMessage}")
                viewModelScope.launch(Dispatchers.Main) {
                    onLoginResult(false, e.localizedMessage)
                }
            }
        }
    }






}
