package com.pidzama.firstframe.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pidzama.firstframe.screens.onBoarding.OnBoardingScreen

fun NavGraphBuilder.onBoardingGraph(navController: NavHostController){
    navigation(
        route = Graph.ONBOARDING,
        startDestination = OnBoardingScreen.Welcome.route
    ){
        composable(OnBoardingScreen.Welcome.route){
            OnBoardingScreen(navController = navController)
        }
    }
}


sealed class OnBoardingScreen(val route: String) {
    object Welcome : OnBoardingScreen("WELCOME")

}