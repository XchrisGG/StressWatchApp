package com.mexware.stresswatch_.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mexware.stresswatch_.connection.ConnectionExpress
import com.mexware.stresswatch_.models.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val _userData = MutableStateFlow<List<UserModel>>(emptyList())
    val userData: StateFlow<List<UserModel>> = _userData.asStateFlow()

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
    fun insertUser(user: UserModel) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = ConnectionExpress.apiService.insertUser(user)
                // Aquí puedes manejar la respuesta si es necesario
                println("Usuario insertado: ${response.nombres} ${response.apellidos}")
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }


}
