package dev.mexware.stresswatch.feature.auth.view.components



import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.mexware.stresswatch.ui.theme.StressDarkBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterLogoHeader(
    @DrawableRes logoRes: Int,
    modifier: Modifier = Modifier,
    showDivider: Boolean = true
) {
    Column(modifier = modifier) {
        CenterAlignedTopAppBar(
            title = {
                Image(
                    painter = painterResource(id = logoRes),
                    contentDescription = "Logo StressWatch",
                    modifier = Modifier.height(48.dp)
                )

            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = StressDarkBlue,
                titleContentColor = MaterialTheme.colorScheme.onSurface
            )

        )
        if (showDivider) Divider()

    }
}
