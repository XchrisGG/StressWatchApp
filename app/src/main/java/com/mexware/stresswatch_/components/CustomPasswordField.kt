@file:OptIn(ExperimentalMaterial3Api::class)

package com.mexware.stresswatch_.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip // Importante para aplicar el clip
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun CustomPasswordField(
    value: String, // Texto ingresado por el usuario
    onValueChange: (String) -> Unit, // Callback para manejar cambios en el texto
    placeholder: String, // Texto del placeholder
    modifier: Modifier = Modifier.fillMaxWidth(), // Modificador predeterminado
    backgroundColor: Color = Color(0xFFADD8E6), // Color de fondo
    placeholderColor: Color = Color.Black, // Color del placeholder
    placeholderFontSize: Int = 18, // Tamaño del texto del placeholder en SP
    textFontSize: Int = 20 // Tamaño del texto ingresado por el usuario
) {
    var passwordVisible by remember { mutableStateOf(false) }

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
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val icon = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                val description = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = icon, contentDescription = description)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 20.sp), // Aquí se ajusta el tamaño de la letra
            colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                containerColor = backgroundColor,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
    }
}



