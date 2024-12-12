import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mexware.stresswatch_.components.ButtonAction
import com.mexware.stresswatch_.models.Sexo // Importa el enum Sexo

@Composable
fun OptionSelection(
    selectedGender: Sexo, // Cambia a Sexo en lugar de String
    onGenderSelected: (Sexo) -> Unit, // Cambia para aceptar un Sexo en lugar de un String
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black // Default text color is black
) {
    var expanded by remember { mutableStateOf(false) }

    // Usamos el enum Sexo para la lista de géneros
    val genders = listOf(Sexo.Masculino, Sexo.Femenino, Sexo.No_especificar)

    Box(modifier = modifier) {
        ButtonAction(
            text = selectedGender.name, // Mostrar el nombre del sexo
            onClick = { expanded = !expanded },
            textColor = textColor // Pasa el color de texto
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            genders.forEach { gender ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        onGenderSelected(gender) // Pasa el valor del enum
                    },
                    text = { Text(text = gender.name, color = textColor) } // Mostrar el nombre del enum
                )
            }
        }
    }
}
