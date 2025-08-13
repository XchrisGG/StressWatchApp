package dev.mexware.stresswatch.feature.splash.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.mexware.stresswatch.R
import dev.mexware.stresswatch.navigation.Screen
import dev.mexware.stresswatch.ui.theme.StressDarkBlue

@Composable
fun LogoScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(StressDarkBlue),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_stress),
                contentDescription = "StressWatch logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(280.dp)
                    .clickable { navController.navigate(Screen.LoginScreen.name) }

            )
        }
    }
}