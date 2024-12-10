package com.mexware.smartwatch.Screens

import EnergyIndicator
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import android.content.Context
import androidx.compose.foundation.rememberScrollState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(context: Context) {
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    val activityStatus = remember { mutableStateOf("Reposo") } // Estado de la actividad
    var energyLevel by remember { mutableStateOf(1f) } // 1.0 = 100%

    // Estado para capturar el valor del acelerómetro
    val accelerometerValue = remember { mutableStateOf(0f) } // Valor real del acelerómetro

    // SensorEventListener para actualizar el valor del acelerómetro
    val sensorListener = rememberUpdatedState(object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            if (event != null && event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                // Calculamos la magnitud del movimiento
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                val acceleration = Math.sqrt((x * x + y * y + z * z).toDouble()).toFloat()

                // Actualizamos el valor del acelerómetro
                accelerometerValue.value = acceleration

                // Actualizamos el estado de actividad
                activityStatus.value = when {
                    acceleration in 9f..10f -> "Reposo"
                    acceleration > 11f -> "Actividad física"
                    else -> activityStatus.value // No cambia si está entre 10 y 11
                }
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    })

    // Iniciar el sensor
    LaunchedEffect(Unit) {
        sensorManager.registerListener(
            sensorListener.value,
            accelerometer,
            SensorManager.SENSOR_DELAY_UI
        )
    }

    // Lógica para la energía (disminuye solo cuando hay actividad física)
    LaunchedEffect(activityStatus.value) {
        if (activityStatus.value == "Actividad física" && energyLevel > 0f) {
            // Si hay actividad, disminuir la energía
            energyLevel = (energyLevel - 0.01f).coerceAtLeast(0f)
        }
    }

    // Interfaz de usuario
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Datos del Reloj") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // Mostrar la barra de energía
            EnergyIndicator(energyLevel)

            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar el estado de la actividad
            Text(
                text = "Estado de la Actividad: ${activityStatus.value}",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}
