

package com.mexware.stresswatch_.layouts

import OptionSelection
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mexware.stresswatch_.R
import com.mexware.stresswatch_.Screens
import com.mexware.stresswatch_.ViewModels.UserViewModel
import com.mexware.stresswatch_.components.BottomAppBar2
import com.mexware.stresswatch_.components.ButtonAction
import com.mexware.stresswatch_.components.TextField
import com.mexware.stresswatch_.models.Sexo

@Composable
fun SexScreen(
    navController: NavHostController,
    userViewModel: UserViewModel

) {
    var sexo by remember { mutableStateOf(Sexo.Masculino) } // Usamos Sexo aquí

    Scaffold(
        bottomBar = {
            BottomAppBar2(
                onBackClick = {
                    navController.navigate(Screens.AgeScreen.name)
                },
                onNextClick = {
                    // Guarda el género seleccionado en UserModel
                    userViewModel.sexo = sexo
                    Log.d("SexScreen", "sexo: ${userViewModel.sexo}")
                    navController.navigate(Screens.InfoScreen.name)
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFF022B53)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                modifier = Modifier
                    .size(300.dp)
                    .padding(top = 20.dp),
                painter = painterResource(id = R.drawable.watch),
                contentDescription = "logo"
            )

            TextField(
                name = "Selecciona tu Género",
                textColor = Color(0xFFFFFDD0),
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(50.dp))

            OptionSelection(
                selectedGender = sexo, // Aquí pasamos el valor del enum Sexo
                onGenderSelected = { newGender ->
                    sexo = newGender // Actualizamos el género seleccionado
                }
            )
        }
    }
}

