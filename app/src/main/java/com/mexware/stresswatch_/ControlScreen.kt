package com.mexware.stresswatch_

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mexware.stresswatch_.layouts.ChatScreen
import com.mexware.stresswatch_.layouts.HomeScreen
import com.mexware.stresswatch_.layouts.LoginRegisterScreen
import com.mexware.stresswatch_.layouts.LoginScreen
import com.mexware.stresswatch_.layouts.LogoScreen
import com.mexware.stresswatch_.layouts.RegisterScreen
import com.mexware.stresswatch_.layouts.UserScreen

@Composable
fun ControlScreen(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.LogoScreen.name,
        enterTransition = { slideIntoContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(300)
        )},
        exitTransition = { slideOutOfContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(300)
        )},
        popEnterTransition = { slideIntoContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(300)
        )},
        popExitTransition = { slideOutOfContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(300)
        )},


        ){
        composable(route = Screens.ChatScreen.name){ ChatScreen( navController) }
        composable(route = Screens.HomeScreen.name){ HomeScreen( navController) }
        composable(route = Screens.LoginRegisterScreen.name){ LoginRegisterScreen( navController) }
        composable(route = Screens.LoginScreen.name){ LoginScreen( navController) }
        composable(route = Screens.LogoScreen.name){ LogoScreen( navController) }
        composable(route = Screens.RegisterScreen.name){ RegisterScreen( navController) }
        composable(route = Screens.UserScreen.name){ UserScreen( navController) }


    }

}


