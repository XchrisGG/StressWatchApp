package com.mexware.stresswatch_.endPoints

import com.mexware.stresswatch_.models.LoginRequest
import com.mexware.stresswatch_.models.LoginResponse
import com.mexware.stresswatch_.models.UserModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// Esta es una interfaz que define el endpoint para obtener datos
interface UserEndPoint {
    @GET("http://192.168.1.10:9000/api/users") // Asumiendo que esta es la URL correcta en tu servidor
    suspend fun getUserData(): List<UserModel>

    @POST("http://192.168.1.10:9000/api/users") // Ruta en tu servidor
    suspend fun insertUser(@Body user: UserModel): UserModel

    @POST("http://192.168.1.10:9000/api/login") // Ruta en tu servidor
    suspend fun login(@Body user: LoginRequest): LoginResponse


}




