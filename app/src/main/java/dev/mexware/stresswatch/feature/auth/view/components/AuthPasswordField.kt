package dev.mexware.stresswatch.feature.auth.view.components


import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import dev.mexware.stresswatch.ui.theme.StressMint
import dev.mexware.stresswatch.ui.theme.StressWhite

/**
 * Campo de contraseña para el feature Auth con toggle de visibilidad.
 * El control de visibilidad es "controlado" por el caller (ViewModel/UiState).
 */
@Composable
fun AuthPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Contraseña",
    isVisible: Boolean,
    onToggleVisibility: () -> Unit,
    errorText: String? = null,
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: () -> Unit = {}
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = StressWhite) },
        singleLine = true,
        isError = errorText != null,
        supportingText = { errorText?.let { Text(it) } },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = onToggleVisibility) {
                if (isVisible) {
                    Icon(Icons.Outlined.VisibilityOff, contentDescription = "Ocultar contraseña")
                } else {
                    Icon(Icons.Outlined.Visibility, contentDescription = "Mostrar contraseña")
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = { onImeAction() }
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = StressWhite,
            unfocusedTextColor = StressWhite,
            focusedLabelColor = StressWhite,
            unfocusedLabelColor = StressWhite,
            cursorColor = StressWhite,
            focusedBorderColor = StressMint,
            unfocusedBorderColor = StressMint.copy(alpha = 0.6f)
        ),
        modifier = modifier
    )
}
