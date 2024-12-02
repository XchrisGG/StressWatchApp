package com.mexware.stresswatch_.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BottomAppBar(navController: NavController) {
    BottomAppBar(
        containerColor = Color(0xFFADD8E6), // Color de fondo
        contentColor = androidx.compose.ui.graphics.Color.Red // Color del contenido
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            IconButton(onClick = { navController.navigate("home") }) {
                Icon(Icons.Filled.Home, contentDescription = "Inicio")
            }
            IconButton(onClick = { navController.navigate("chat") }) {
                Icon(Icons.Filled.Home, contentDescription = "chat")
            }
            IconButton(onClick = {navController.navigate("user") }) {
                Icon(Icons.Filled.Home, contentDescription = "Usuario")
            }


        }
    }
}