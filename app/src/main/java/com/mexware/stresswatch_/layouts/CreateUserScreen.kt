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
import com.mexware.stresswatch_.components.CustomPasswordField
import com.mexware.stresswatch_.components.CustomTextField
import com.mexware.stresswatch_.components.TextField
import com.mexware.stresswatch_.models.UserModel

@Composable
fun CreateUserScreen(
    navController: NavHostController,
    userViewModel: UserViewModel
    ) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }



    Scaffold(

        bottomBar = {
            BottomAppBar2(
                onBackClick = {
                    // Acción cuando se hace clic en la flecha
                    navController.navigate(Screens.InfoScreen.name)
                },
                onNextClick = {
                    userViewModel.email = email
                    userViewModel.password =  password
                    Log.d("CreateUserScreen", "email: ${userViewModel.email}")
                    Log.d("CreateUserScreen", "passord: ${userViewModel.password}")
                    userViewModel.insertUser()



                    navController.navigate(Screens.HomeScreen.name)
                }
            )



        }

    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el espacio disponible
                .padding(padding) // Respeta el padding del Scaffold
                .background(Color(0xFF022B53)), // Color de fondo
            horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente
            verticalArrangement = Arrangement.Top // Comienza desde arriba
        ) {
            Image(
                modifier = Modifier
                    .size(300.dp)
                    .padding(top = 20.dp), // Espaciado superior opcional
                painter = painterResource(id = R.drawable.watch),
                contentDescription = "logo"
            )


            TextField(
                name = "Crea un Perfil Seguro",
                textColor = Color(0xFFFFFDD0), // Color del texto
                fontSize = 25.sp, // Tamaño de la fuente
                fontWeight = FontWeight.Black, // Peso de la fuente

            )
            Spacer(modifier = Modifier.height(50.dp)) // Espaciado



            TextField(
                name = "Ingresa tu Correo electronico",
                textColor = Color(0xFFFFFDD0), // Color del texto
                fontSize = 18.sp, // Tamaño de la fuente
                // Peso de la fuente

            )

            Spacer(modifier = Modifier.height(25.dp)) // Espaciado
            CustomTextField(
                value = email, // Estado que almacena el texto ingresado
                onValueChange = { newText -> email = newText },
                placeholder = "Christian@gmail.com", // Texto del placeholder
                modifier = Modifier.fillMaxWidth(0.9f) // Ajusta el ancho si es necesario
            )
            Spacer(modifier = Modifier.height(50.dp)) // Espaciado


            TextField(
                name = "Ingresa tu contraseña",
                textColor = Color(0xFFFFFDD0), // Color del texto
                fontSize = 18.sp, // Tamaño de la fuente
                // Peso de la fuente

            )
            Spacer(modifier = Modifier.height(25.dp)) // Espaciado


            CustomPasswordField(
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                placeholder = "Contraseña",
                modifier = Modifier.fillMaxWidth(0.9f)
            )

        }
    }
}

