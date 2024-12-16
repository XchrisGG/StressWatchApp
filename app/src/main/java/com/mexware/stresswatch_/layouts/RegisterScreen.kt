package com.mexware.stresswatch_.layouts

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mexware.stresswatch_.R
import com.mexware.stresswatch_.Screens
import com.mexware.stresswatch_.components.BottomAppBar
import com.mexware.stresswatch_.components.BottomAppBar2
import com.mexware.stresswatch_.components.OptionCard
import com.mexware.stresswatch_.components.SimpleTextCard
import com.mexware.stresswatch_.components.TextField
import com.mexware.stresswatch_.components.TopApp
import com.mexware.stresswatch_.ui.theme.stresswatchthme.AppTheme

@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopApp(navController = navController, title = "Registro")

        },


        bottomBar = {
            BottomAppBar2(
                onBackClick = {
                    // Acción cuando se hace clic en la flecha
                    navController.navigate(Screens.LoginRegisterScreen.name)
                },
                onNextClick = {
                    // Acción cuando se hace clic en "Siguiente"
                    navController.navigate(Screens.NameScreen.name)
                }
            )

        }

    ){ padding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.background) // Fondo azul oscuro
                .verticalScroll(rememberScrollState()), // Permitir scroll si es necesario
            horizontalAlignment = Alignment.CenterHorizontally // Centrar contenido
        ) {
            Text(
                text = "Recuerda Que:", // Texto de bienvenida
                color = androidx.compose.ui.graphics.Color.White,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .fillMaxWidth() // Hace que el texto ocupe todo el ancho disponible
                    .padding(start = 16.dp) // Margen desde la izquierda
                    .align(Alignment.Start) // Alinea el texto hacia la izquierda
            )
            Spacer(modifier = Modifier.height(16.dp))

            SimpleTextCard(
                text = "La App no busca reemplazar la terapia profesional, busca ser un complemento para etsa misma y te ayude en tu recorrido", // El texto que deseas mostrar en la tarjeta
                backgroundColor = Color(0xFFADD8E6), // El color de fondo de la tarjeta
                onClick = {
                    // Acción que ocurre cuando se hace clic en la tarjeta
                    // Puedes reemplazar esto con cualquier lógica que desees
                }
            )

            SimpleTextCard(
                text = "La App no busca reemplazar la terapia profesional, busca ser un complemento para etsa misma y te ayude en tu recorrido", // El texto que deseas mostrar en la tarjeta
                backgroundColor = Color(0xFFADD8E6), // El color de fondo de la tarjeta
                onClick = {
                    // Acción que ocurre cuando se hace clic en la tarjeta
                    // Puedes reemplazar esto con cualquier lógica que desees
                }
            )

            SimpleTextCard(
                text = "La App no busca reemplazar la terapia profesional, busca ser un complemento para etsa misma y te ayude en tu recorrido", // El texto que deseas mostrar en la tarjeta
                backgroundColor = Color(0xFFADD8E6), // El color de fondo de la tarjeta
                onClick = {
                    // Acción que ocurre cuando se hace clic en la tarjeta
                    // Puedes reemplazar esto con cualquier lógica que desees
                }
            )

        }


    }

}
