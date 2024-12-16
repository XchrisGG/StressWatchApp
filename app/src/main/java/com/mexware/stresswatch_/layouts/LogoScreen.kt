package com.mexware.stresswatch_.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mexware.stresswatch_.R
import com.mexware.stresswatch_.Screens
import com.mexware.stresswatch_.ui.theme.stresswatchthme.AppTheme

@Composable
fun LogoScreen(navController: NavHostController) {
    Scaffold (


    ){ padding ->
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el espacio disponible
                .padding(padding) // Respeta el espacio de las barras
                .background(MaterialTheme.colorScheme.background),// Color de fondo del Box
                    horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ){
            Image(
                modifier = Modifier.
                fillMaxWidth()
                    .scale(3f)
                    .clickable {
                        navController.navigate(Screens.LoginRegisterScreen.name)
                    },
                painter = painterResource(id = R.drawable.watch),
                contentDescription = "logo")

        }

    }
    }


