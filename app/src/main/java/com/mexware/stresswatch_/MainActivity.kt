package com.mexware.stresswatch_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mexware.stresswatch_.layouts.ChatScreen
import com.mexware.stresswatch_.layouts.FormLogin
import com.mexware.stresswatch_.layouts.HomeScreen
import com.mexware.stresswatch_.ui.theme.StressWatch_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "home"){
                composable(route = "home"){ HomeScreen() }
                composable(route = "Chat"){ ChatScreen() }
            }

        }
    }
}

