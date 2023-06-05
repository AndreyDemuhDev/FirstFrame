package com.pidzama.firstframe.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pidzama.firstframe.screens.auth.ForgotScreen
import com.pidzama.firstframe.screens.auth.LoginScreen
import com.pidzama.firstframe.screens.auth.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = AuthScreen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = AuthScreen.Forgot.route) {
            ForgotScreen(navController = navController)
        }
    }
}


sealed class AuthScreen(val route: String) {
    object Login : AuthScreen("LOGIN")
    object SignUp : AuthScreen("SIGN_UP")
    object Forgot : AuthScreen("FORGOT")
}
