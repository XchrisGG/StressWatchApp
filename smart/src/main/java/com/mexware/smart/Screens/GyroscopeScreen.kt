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
fun GyroscopeScreen() {
    // Estado para almacenar los valores del giroscopio
    val gyroscopeData = remember { mutableStateOf("Esperando datos...") }

    // Obtenemos el contexto de la aplicación
    val context = LocalContext.current
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    // Creamos un SensorEventListener para escuchar los cambios del sensor
    val sensorEventListener = remember {
        object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                if (event != null && event.sensor.type == Sensor.TYPE_GYROSCOPE) {
                    // Aquí obtenemos los valores de la rotación del giroscopio
                    val x = event.values[0]
                    val y = event.values[1]
                    val z = event.values[2]

                    // Actualizamos el estado con los nuevos datos
                    gyroscopeData.value = "Rotación - X: $x, Y: $y, Z: $z"
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // No necesitamos manejar los cambios de precisión en este caso
            }
        }
    }

    // Registramos el sensor al cargar la pantalla
    LaunchedEffect(true) {
        val gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        if (gyroscope != null) {
            sensorManager.registerListener(sensorEventListener, gyroscope, SensorManager.SENSOR_DELAY_UI)
        } else {
            Log.e("HomeScreenGyroscope", "Giroscopio no disponible.")
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
        Text(text = "Datos del Giroscopio:\n${gyroscopeData.value}")
    }
}
