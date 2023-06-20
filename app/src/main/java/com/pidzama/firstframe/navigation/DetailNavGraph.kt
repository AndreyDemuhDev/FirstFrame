package com.pidzama.firstframe.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pidzama.firstframe.screens.details.DetailPersonScreen
import com.pidzama.firstframe.screens.details.DetailsTitleScreen


fun NavGraphBuilder.detailNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailScreen.DetailTitle.route
    ) {
        composable(route = DetailScreen.DetailTitle.route + "/{id}") { backStackEntry ->
            DetailsTitleScreen(
                id = backStackEntry.arguments?.getString("id") ?: "1",
                navController = navController
            )
        }
        composable(route = DetailScreen.DetailPerson.route + "/{id}"){navBackStackEntry ->
            DetailPersonScreen(
                id = navBackStackEntry.arguments?.getString("id")?: "1",
                navController = navController
            )
        }
    }
}


sealed class DetailScreen(val route: String) {
    object DetailTitle : DetailScreen(route = "DETAIL_TITLE")
    object DetailPerson : DetailScreen(route = "DETAIL_PERSON")
    object DetailSeason : DetailScreen(route = "DETAIL_SEASON")
}