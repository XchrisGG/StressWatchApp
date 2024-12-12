package com.mexware.stresswatch_.components

import android.app.DatePickerDialog
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.* // Importar java.util para trabajar con Date y Calendar

@Composable
fun CustomDateTextField(
    fechaNacimiento: Date?, // Cambiado a tipo Date
    onDateChange: (Date) -> Unit
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Configurar el año, mes y día actuales a partir de la fecha o la fecha actual
    fechaNacimiento?.let { calendar.time = it }
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            // Actualizar el calendario con la nueva fecha seleccionada
            calendar.set(selectedYear, selectedMonth, selectedDay)
            val selectedDate = calendar.time // Obtener el Date actualizado
            onDateChange(selectedDate)
        },
        year, month, day
    )

    // Usamos SimpleDateFormat para formatear solo la fecha (sin la hora)
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val formattedDate = fechaNacimiento?.let { dateFormat.format(it) }

    Button(onClick = { datePickerDialog.show() }) {
        Text(text = formattedDate ?: "Selecciona tu fecha de nacimiento")
    }
}
