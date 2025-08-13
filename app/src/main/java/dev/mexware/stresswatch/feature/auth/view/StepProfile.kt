package dev.mexware.stresswatch.feature.auth.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.mexware.stresswatch.feature.auth.view.components.AvatarCarousel
import dev.mexware.stresswatch.feature.auth.view.components.BirthDateField
import dev.mexware.stresswatch.feature.auth.view.components.CountryDropdown
import dev.mexware.stresswatch.ui.theme.StressDarkBlue

@Composable
fun StepProfile(
    birthDate: String,
    country: String,
    avatarId: Int?,
    errors: Map<String, String>,
    onBirthDate: (String) -> Unit,
    onCountry: (String) -> Unit,
    onAvatar: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StressDarkBlue)
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Selecciona un avatar",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )
        AvatarCarousel(
            selectedId = avatarId,
            onSelect = onAvatar
        )

        Text(
            text = "Ingresa tu fecha de nacimiento",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp)
        )
        BirthDateField(
            value = birthDate,
            onValueChange = onBirthDate,
            modifier = Modifier.fillMaxWidth(),
            errorText = errors["birthDate"]
        )

        Text(
            text = "Selecciona el país donde vives:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            modifier = Modifier.padding(top = 4.dp)
        )
        CountryDropdown(
            selected = country,
            onSelected = onCountry,
            modifier = Modifier.fillMaxWidth(),
            errorText = errors["country"]
        )
    }
}