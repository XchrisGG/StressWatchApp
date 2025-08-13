package dev.mexware.stresswatch.feature.auth.view


import dev.mexware.stresswatch.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.mexware.stresswatch.components.CircleConsentCheckbox
import dev.mexware.stresswatch.feature.auth.view.components.PillInfoCard
import dev.mexware.stresswatch.ui.theme.StressDarkBlue
import dev.mexware.stresswatch.ui.theme.StressGrayLight


/**
 * No tiene botón "Siguiente".
 * Muestra tarjetas y un checkbox circular para aceptar.
 * El avance lo controla la barra inferior; solo se habilita si 'accepted' es true.
 */
@Composable
fun StepDisclaimer(
    accepted: Boolean,
    onAcceptedChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StressDarkBlue)
            .padding(horizontal = 24.dp, vertical = 40.dp),


        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {


        Text("Recuerda que", style = MaterialTheme.typography.headlineMedium, color = StressGrayLight)

        PillInfoCard(
            text = "En caso de una situación de crisis, recuerda que la app te brinda “Ayuda” para comunicarte con una línea externa de crisis."
        )

        PillInfoCard(
            text = "La App no busca reemplazar la terapia profesional; es un complemento para tu proceso."
        )
        PillInfoCard(
            text = "La app no puede determinar un diagnóstico. Acude siempre con profesionales de la salud."
        )

        CircleConsentCheckbox(
            checked = accepted,
            onCheckedChange = onAcceptedChange,
            label = "He leído y acepto"
        )
    }
}
