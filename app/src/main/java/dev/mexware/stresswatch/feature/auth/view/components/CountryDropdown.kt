package dev.mexware.stresswatch.feature.auth.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Selector de país con colores estáticos.
 * Usa datos emulados; cuando conectes BD, pásalos en 'countries'.
 */
@Composable
fun CountryDropdown(
    selected: String,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    countries: List<String> = listOf(
        "México", "Estados Unidos", "España", "Argentina",
        "Colombia", "Chile", "Perú", "Uruguay"
    ),
    placeholder: String = "País de residencia",
    errorText: String? = null
) {
    val bg = Color(0xFF5FBCA7)
    val textColor = Color(0xFF0D0D0D)
    val hintColor = Color(0x990D0D0D)
    val errorColor = Color(0xFFD32F2F)
    val shape = RoundedCornerShape(18.dp)

    var expanded by remember { mutableStateOf(false) }

    Box {
        Box(
            modifier = modifier
                .background(bg, shape)
                .clickable { expanded = true }
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = if (selected.isBlank()) placeholder else selected,
                color = if (selected.isBlank()) hintColor else textColor,
                fontSize = 16.sp
            )
        }

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            countries.forEach { country ->
                DropdownMenuItem(
                    text = { Text(country) },
                    onClick = {
                        onSelected(country)
                        expanded = false
                    }
                )
            }
        }
    }

    if (!errorText.isNullOrBlank()) {
        Text(
            text = errorText,
            color = errorColor,
            fontSize = 13.sp,
            modifier = Modifier.padding(top = 6.dp, start = 4.dp)
        )
    }
}