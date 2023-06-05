package com.pidzama.firstframe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pidzama.firstframe.screens.home.HomeScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = startDestination
    ) {
        onBoardingGraph(navController = navController)
        authNavGraph(navController = navController)
        composable(route = Graph.HOME) {
            HomeScreen()
        }
    }
}


object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val ONBOARDING = "onboarding_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
    const val SETTINGS = "settings_graph"
}