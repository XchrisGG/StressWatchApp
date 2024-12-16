@file:OptIn(ExperimentalMaterial3Api::class)

package com.mexware.stresswatch_.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CustomNumericTextField(
    value: String, // Texto ingresado por el usuario
    onValueChange: (String) -> Unit, // Callback para manejar cambios en el texto
    placeholder: String, // Texto del placeholder
    modifier: Modifier = Modifier.fillMaxWidth(), // Modificador predeterminado
    backgroundColor: Color= MaterialTheme.colorScheme.inversePrimary, // Color de fondo
    placeholderColor: Color = MaterialTheme.colorScheme.primaryContainer, // Color del placeholder
    placeholderFontSize: Int = 18 // Tamaño del texto del placeholder en SP
) {
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = CornerSize(25.dp),
                    topEnd = CornerSize(25.dp),
                    bottomStart = CornerSize(0.dp),
                    bottomEnd = CornerSize(0.dp)
                )
            )
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    style = TextStyle(
                        color = placeholderColor,
                        fontSize = placeholderFontSize.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            },
            shape = RoundedCornerShape(
                topStart = CornerSize(25.dp),
                topEnd = CornerSize(25.dp),
                bottomStart = CornerSize(0.dp),
                bottomEnd = CornerSize(0.dp)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topStart = CornerSize(25.dp),
                        topEnd = CornerSize(25.dp),
                        bottomStart = CornerSize(0.dp),
                        bottomEnd = CornerSize(0.dp)
                    )
                ),
            textStyle = TextStyle(fontSize = 20.sp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number // Configura el teclado como numérico
            ),
            colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                containerColor = backgroundColor,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
    }
}


