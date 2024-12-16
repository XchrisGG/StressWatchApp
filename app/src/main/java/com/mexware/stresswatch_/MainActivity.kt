package com.mexware.stresswatch_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mexware.stresswatch_.layouts.ChatScreen
import com.mexware.stresswatch_.layouts.HomeScreen
import com.mexware.stresswatch_.layouts.UserScreen
import com.mexware.stresswatch_.ui.theme.stresswatchthme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
            ControlScreen()
            }

        }
    }
}

