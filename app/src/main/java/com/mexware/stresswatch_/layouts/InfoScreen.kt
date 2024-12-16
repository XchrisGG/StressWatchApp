package com.mexware.stresswatch_.layouts

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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.mexware.stresswatch_.components.AvatarSelection
import com.mexware.stresswatch_.components.BottomAppBar2
import com.mexware.stresswatch_.components.CustomDateTextField
import com.mexware.stresswatch_.components.CustomTextField
import com.mexware.stresswatch_.components.TextField
import com.mexware.stresswatch_.components.TopApp
import com.mexware.stresswatch_.models.Sexo
import com.mexware.stresswatch_.models.UserModel
import java.time.LocalDate
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(
    navController: NavHostController,
    userViewModel: UserViewModel

) {
    var pais by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf(Date()) }

    val avatars = listOf(
        R.drawable.avatar1,
        R.drawable.avatar2,
        R.drawable.avatar3,
        R.drawable.avatar4,
        R.drawable.avatar5

    )

    var selectedAvatar by remember { mutableStateOf(-1) }
    Scaffold(
        topBar = {
            TopApp(navController = navController, title = "Información")

        },
        bottomBar = {
            BottomAppBar2(
                onBackClick = {
                    // Acción cuando se hace clic en la flecha
                    navController.navigate(Screens.SexScreen.name)
                },
                onNextClick = {
                    userViewModel.pais = pais
                    userViewModel.fechaNacimiento = fechaNacimiento




                    Log.d("InfoScreen", "fechaNacimiento ${userViewModel.fechaNacimiento}")
                    Log.d("InfoScreen", "pais ${userViewModel.pais}")

                    navController.navigate(Screens.CreateUserScreen.name)
                }

            )



        }

    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el espacio disponible
                .padding(padding) // Respeta el padding del Scaffold
                .background(MaterialTheme.colorScheme.background), // Color de fondo
            horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente
            verticalArrangement = Arrangement.Top // Comienza desde arriba
        ) {

            Spacer(modifier = Modifier.height(50.dp)) // Espaciado

            TextField(
                name = "Casi finalizamos Christian",
                textColor = Color(0xFFFFFDD0), // Color del texto
                fontSize = 25.sp, // Tamaño de la fuente
                fontWeight = FontWeight.Black, // Peso de la fuente

            )
            Spacer(modifier = Modifier.height(25.dp)) // Espaciado





            Spacer(modifier = Modifier.height(50.dp)) // Espaciado

            AvatarSelection(avatars = avatars) { avatarRes ->
                selectedAvatar = avatarRes
            }
            Spacer(modifier = Modifier.height(50.dp)) // Espaciado




            TextField(
                name = "Ingresa tu fecha de nacimiento",
                textColor = Color(0xFFFFFDD0), // Color del texto
                fontSize = 18.sp, // Tamaño de la fuente
                // Peso de la fuente

            )

            Spacer(modifier = Modifier.height(25.dp)) // Espaciado

            CustomDateTextField(
                fechaNacimiento = fechaNacimiento,
                onDateChange = { nuevaFecha ->
                    fechaNacimiento = nuevaFecha
                }
            )

            Spacer(modifier = Modifier.height(50.dp)) // Espaciado

            TextField(
                name = "Ingresa tu Pais",
                textColor = Color(0xFFFFFDD0), // Color del texto
                fontSize = 18.sp, // Tamaño de la fuente
                // Peso de la fuente

            )
            Spacer(modifier = Modifier.height(25.dp)) // Espaciado



            CustomTextField(
                value = pais, // Estado que almacena el texto ingresado
                onValueChange = { newText -> pais = newText },
                placeholder = "País de residencia", // Texto del placeholder
                modifier = Modifier.fillMaxWidth(0.9f) // Ajusta el ancho si es necesario
            )


        }
    }
}

