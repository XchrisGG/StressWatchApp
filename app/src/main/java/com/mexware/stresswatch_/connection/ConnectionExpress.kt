package com.mexware.stresswatch_.connection

import com.mexware.stresswatch_.endPoints.UserEndPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Este es un objeto singleton que configura Retrofit
object ConnectionExpress {
    val apiService: UserEndPoint = Retrofit.Builder()
        .baseUrl("https://backexpress-1.onrender.com") // URL base de tu servidor
        .addConverterFactory(GsonConverterFactory.create()) // Convierte JSON a objetos Kotlin
        .build()
        .create(UserEndPoint::class.java)
}
