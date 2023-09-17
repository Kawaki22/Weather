package com.kawaki.weather.navigation

import com.kawaki.weather.R

sealed class NavScreens(
    val route: String,
    val name: String,
    val icon: Int
) {
    data object HomeScreen: NavScreens(route = "HomeScreen", name = "Home", icon = R.drawable.home)
    data object SearchScreen: NavScreens(route = "SearchScreen", name = "Search", icon = R.drawable.search)

    object Items {
        val list = listOf<NavScreens>(
            NavScreens.HomeScreen,
            NavScreens.SearchScreen
        )
    }
}
