package com.mexware.stresswatch_.layouts
import com.mexware.stresswatch_.components.TopApp
import com.mexware.stresswatch_.components.BottomAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController


@Composable
fun ChatScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopApp(navController = navController, title = "Chat")


        },

        bottomBar = {
            BottomAppBar(navController = navController)

        }

    ){ padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ){
            //Mensajes
            Box

            }
            //Salida de menssajes
            Box {

            }
        }

    }
}