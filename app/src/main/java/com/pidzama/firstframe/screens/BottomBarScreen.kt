package com.pidzama.firstframe.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "HOME",
        title = "HOME",
        icon = Icons.Default.Home
    )

    object Search : BottomBarScreen(
        route = "SEARCH",
        title = "SEARCH",
        icon = Icons.Default.Search
    )

    object Favorite : BottomBarScreen(
        route = "FAVORITE",
        title = "FAVORITE",
        icon = Icons.Default.Favorite
    )

    object Profile : BottomBarScreen(
        route = "PROFILE",
        title = "PROFILE",
        icon = Icons.Default.Person
    )
}