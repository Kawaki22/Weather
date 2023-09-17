package com.kawaki.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kawaki.weather.screens.HomeScreen

@Composable
fun WeatherAppNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = NavScreens.HomeScreen.route) {
        composable(NavScreens.HomeScreen.route) {
            HomeScreen(navHostController = navHostController)
        }
    }
}