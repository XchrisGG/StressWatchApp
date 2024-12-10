package com.mexware.smart.Screens

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import androidx.compose.runtime.Composable

@Composable
fun remember(
    onSensorChanged: (SensorEvent) -> Unit

): SensorEventListener {
    return remember {
        object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                if (event != null) {
                    onSensorChanged(event)
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // Aquí puedes manejar la precisión del sensor si es necesario
            }
        }
    }

}