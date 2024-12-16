package com.mexware.stresswatch_.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mexware.stresswatch_.Screens
import com.mexware.stresswatch_.ui.theme.stresswatchthme.AppTheme

@Composable
fun BottomAppBar(navController: NavController) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.inversePrimary, // Color de fondo
        contentColor = androidx.compose.ui.graphics.Color.Red // Color del contenido
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            IconButton(onClick = { navController.navigate(Screens.HomeScreen.name) }) {
                Icon(Icons.Filled.Home, contentDescription = "Inicio")
            }
            IconButton(onClick = { navController.navigate(Screens.ChatScreen.name) }) {
                Icon(Icons.Filled.Home, contentDescription = "chat")
            }
            IconButton(onClick = {navController.navigate(Screens.UserScreen.name) }) {
                Icon(Icons.Filled.Home, contentDescription = "Usuario")
            }


        }
    }

}