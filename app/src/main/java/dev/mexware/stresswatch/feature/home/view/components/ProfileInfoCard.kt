package dev.mexware.stresswatch.feature.home.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Card con filas de información del perfil.
 * Fondo azul oscuro (coincide con tus pantallas).
 */
@Composable
fun ProfileInfoCard(
    name: String,
    genderText: String,
    birthDate: String,
    country: String,
    modifier: Modifier = Modifier
) {
    val cardBg = Color(0xFF022B53) // azul oscuro del proyecto
    Surface(color = cardBg, modifier = modifier) {
        Column(Modifier.padding(16.dp)) {
            ProfileInfoRow(label = "Nombre", value = name)
            Spacer(Modifier.height(10.dp))
            ProfileInfoRow(label = "Género", value = genderText)
            Spacer(Modifier.height(10.dp))
            ProfileInfoRow(label = "Nacimiento", value = birthDate)
            Spacer(Modifier.height(10.dp))
            ProfileInfoRow(label = "País", value = country)
        }
    }
}