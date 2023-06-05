package com.pidzama.firstframe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pidzama.firstframe.screens.BottomBarScreen
import com.pidzama.firstframe.screens.home.StartScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            StartScreen(text = BottomBarScreen.Home.route)
        }
        composable(route = BottomBarScreen.Search.route) {
            StartScreen(text = BottomBarScreen.Search.route)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            StartScreen(text = BottomBarScreen.Favorite.route)
        }
        composable(route = BottomBarScreen.Profile.route) {
            StartScreen(text = BottomBarScreen.Profile.route)
        }
    }
}

