package com.mexware.smartwatch.Screens

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.wear.compose.material.Text

@Composable
fun LightSensorHomeScreen() {
    // Estado para almacenar el valor de la luz
    val lightData = remember { mutableStateOf("Esperando datos...") }

    // Obtenemos el contexto de la aplicación
    val context = LocalContext.current
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    // Creamos un SensorEventListener para escuchar los cambios del sensor
    val sensorEventListener = remember {
        object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                if (event != null && event.sensor.type == Sensor.TYPE_LIGHT) {
                    // Aquí obtenemos el valor del sensor de luz
                    val lightLevel = event.values[0]

                    // Actualizamos el estado con los nuevos datos
                    lightData.value = "Nivel de luz: $lightLevel lux"
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // No necesitamos manejar los cambios de precisión en este caso
            }
        }
    }

    // Registramos el sensor al cargar la pantalla
    LaunchedEffect(true) {
        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        if (lightSensor != null) {
            sensorManager.registerListener(sensorEventListener, lightSensor, SensorManager.SENSOR_DELAY_UI)
        } else {
            Log.e("HomeScreenLightSensor", "Sensor de luz no disponible.")
        }
    }

    // Asegúrate de desregistrar el sensor cuando la pantalla no esté activa
    DisposableEffect(true) {
        onDispose {
            sensorManager.unregisterListener(sensorEventListener)
        }
    }

    // Diseño de la UI
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Datos del Sensor de Luz:\n${lightData.value}")
    }
}
