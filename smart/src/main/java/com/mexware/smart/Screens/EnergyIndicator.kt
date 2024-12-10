import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EnergyIndicator(energyLevel: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = energyLevel,
            modifier = Modifier.size(150.dp),
            color = Color.Green,
            strokeWidth = 8.dp
        )
        Text(
            text = "${(energyLevel * 100).toInt()}%",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black
        )
    }
}
