package com.pidzama.firstframe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pidzama.firstframe.screens.BottomBarScreen
import com.pidzama.firstframe.screens.home.*
import com.pidzama.firstframe.screens.home.tabScreens.HomeScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen()
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(text = BottomBarScreen.Profile.route)
        }
        detailNavGraph(navController)
    }
}