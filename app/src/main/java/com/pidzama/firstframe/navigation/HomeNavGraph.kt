package com.pidzama.firstframe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pidzama.firstframe.screens.BottomBarScreen
import com.pidzama.firstframe.screens.home.FavoriteScreen
import com.pidzama.firstframe.screens.home.SearchScreen
import com.pidzama.firstframe.screens.home.MainScreen
import com.pidzama.firstframe.screens.home.ProfileScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            MainScreen(text = BottomBarScreen.Home.route)
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(text = BottomBarScreen.Search.route)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen(text = BottomBarScreen.Favorite.route)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(text = BottomBarScreen.Profile.route)
        }
    }
}

