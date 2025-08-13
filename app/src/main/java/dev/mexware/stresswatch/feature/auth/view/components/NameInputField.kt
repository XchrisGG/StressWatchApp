package dev.mexware.stresswatch.feature.auth.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text

/**
 * Campo de texto con estilo fijo (no depende del theme).
 * Fondeado verde con esquinas redondeadas, como en tu diseño.
 */
@Composable
fun NameInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Tu nombre",
    errorText: String? = null
) {
    // Colores fijos (del propio componente)
    val fieldBg = Color(0xFF5FBCA7)      // verde pastel del mock
    val textColor = Color(0xFF0D0D0D)    // casi negro
    val hintColor = Color(0x990D0D0D)    // negro con transparencia
    val errorColor = Color(0xFFFFE082)   // amarillo suave para aviso (opcional)

    val shape = RoundedCornerShape(18.dp)

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(color = textColor, fontSize = 18.sp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Words,
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier
                    .background(color = fieldBg, shape = shape)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                if (value.isEmpty()) {
                    Text(text = placeholder, color = hintColor, fontSize = 18.sp)
                }
                innerTextField()
            }
        }
    )

    // Mensaje de error opcional
    if (!errorText.isNullOrBlank()) {
        Text(
            text = errorText,
            color = errorColor,
            fontSize = 13.sp,
            modifier = Modifier.padding(top = 6.dp, start = 4.dp)
        )
    }
}