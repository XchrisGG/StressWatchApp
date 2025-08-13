package dev.mexware.stresswatch.feature.auth.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.foundation.text.KeyboardOptions

/**
 * Campo con colores estáticos y formateo DD/MM/AAAA.
 * No abre date picker; solo aplica máscara y entrega el valor formateado.
 */
@Composable
fun BirthDateField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "DD/MM/AAAA",
    errorText: String? = null
) {
    val bg = Color(0xFF5FBCA7)     // verde pastel
    val textColor = Color(0xFF0D0D0D)
    val hintColor = Color(0x990D0D0D)
    val errorColor = Color(0xFFD32F2F)
    val shape = RoundedCornerShape(18.dp)

    fun mask(input: String): String {
        val digits = input.filter { it.isDigit() }.take(8)
        val sb = StringBuilder()
        for (i in digits.indices) {
            sb.append(digits[i])
            if (i == 1 || i == 3) sb.append('/')
        }
        return sb.toString()
    }

    BasicTextField(
        value = value,
        onValueChange = { onValueChange(mask(it)) },
        textStyle = TextStyle(color = textColor, fontSize = 16.sp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        decorationBox = { inner ->
            Box(
                modifier = modifier
                    .background(bg, shape)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                if (value.isBlank()) {
                    Text(text = placeholder, color = hintColor, fontSize = 16.sp)
                }
                inner()
            }
        }
    )

    if (!errorText.isNullOrBlank()) {
        Text(
            text = errorText,
            color = errorColor,
            fontSize = 13.sp,
            modifier = Modifier.padding(top = 6.dp, start = 4.dp)
        )
    }
}