import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mexware.stresswatch_.components.ButtonAction

@Composable
fun OptionSelection(
    selectedGender: String,
    onGenderSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black // Default text color is black
) {
    var expanded by remember { mutableStateOf(false) }
    val genders = listOf("Masculino", "Femenino", "Otro")

    Box(modifier = modifier) {
        ButtonAction(
            text = selectedGender,
            onClick = { expanded = !expanded },
            textColor = textColor // Pass the textColor to ButtonAction
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            genders.forEach { gender ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        onGenderSelected(gender)
                    },
                    text = { Text(text = gender, color = textColor) } // Use the textColor here as well
                )
            }
        }
    }
}