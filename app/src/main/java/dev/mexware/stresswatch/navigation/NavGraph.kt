package dev.mexware.stresswatch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.mexware.stresswatch.feature.auth.view.LoginScreen
import dev.mexware.stresswatch.feature.auth.view.RegisterScreen
import dev.mexware.stresswatch.feature.main.view.MainScreen
import dev.mexware.stresswatch.feature.splash.view.LogoScreen

@Composable
fun NavGraph(){
    val navControler = rememberNavController()


    NavHost(navControler, startDestination =  "logo"){
        composable(route = Screen.LogoScreen.name){ LogoScreen(navControler) }
        composable(route = Screen.LoginScreen.name) { LoginScreen(navControler) }
        composable(route = Screen.RegisterScreen.name) { RegisterScreen(navControler) }
        composable(route = Screen.MainScreen.name) { MainScreen(navControler) }
    }
}