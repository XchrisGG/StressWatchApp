package com.mexware.stresswatch_

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mexware.stresswatch_.ViewModels.UserViewModel
import com.mexware.stresswatch_.layouts.AgeScreen
import com.mexware.stresswatch_.layouts.ChatScreen
import com.mexware.stresswatch_.layouts.HomeScreen
import com.mexware.stresswatch_.layouts.LoginRegisterScreen
import com.mexware.stresswatch_.layouts.LoginScreen
import com.mexware.stresswatch_.layouts.LogoScreen
import com.mexware.stresswatch_.layouts.NameScreen
import com.mexware.stresswatch_.layouts.RegisterScreen
import com.mexware.stresswatch_.layouts.UserScreen
import com.mexware.stresswatch_.layouts.RecoverPassword
import com.mexware.stresswatch_.layouts.SexScreen
import com.mexware.stresswatch_.layouts.InfoScreen
import com.mexware.stresswatch_.layouts.CreateUserScreen


@Composable
fun ControlScreen(){
    val navController = rememberNavController()
    val userViewModel: UserViewModel = androidx.lifecycle.viewmodel.compose.viewModel()


    NavHost(
        navController = navController,
        startDestination = Screens.ChatScreen.name,
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
        composable(route = Screens.ChatScreen.name) { ChatScreen(navController) }
        composable(route = Screens.HomeScreen.name) { HomeScreen(navController) }
        composable(route = Screens.LoginRegisterScreen.name) { LoginRegisterScreen(navController) }
        composable(route = Screens.LoginScreen.name) { LoginScreen(navController) }
        composable(route = Screens.LogoScreen.name) { LogoScreen(navController) }
        composable(route = Screens.RegisterScreen.name) { RegisterScreen(navController) }
        composable(route = Screens.UserScreen.name) { UserScreen(navController) }
        composable(route = Screens.RecoverPasswordScreen.name) { RecoverPassword(navController) }
        composable(route = Screens.NameScreen.name) {
            NameScreen(navController = navController, userViewModel = userViewModel)
        }
        composable(route = Screens.AgeScreen.name) {
            AgeScreen(navController = navController, userViewModel = userViewModel)
        }
        composable(route = Screens.SexScreen.name) {
            SexScreen(navController = navController, userViewModel = userViewModel)
        }
        composable(route = Screens.InfoScreen.name) {
            InfoScreen(navController = navController, userViewModel = userViewModel)
        }
        composable(route = Screens.CreateUserScreen.name) {
            CreateUserScreen(navController = navController, userViewModel = userViewModel)
        }




    }

}


