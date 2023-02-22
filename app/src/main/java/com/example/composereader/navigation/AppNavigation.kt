package com.example.composereader.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composereader.screens.SplashScreen
import com.example.composereader.screens.details.DetailsScreen
import com.example.composereader.screens.home.Home
import com.example.composereader.screens.login.LoginScreen
import com.example.composereader.screens.search.SearchScreen
import com.example.composereader.screens.statistics.StatsScreen
import com.example.composereader.screens.update.UpdateScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name) {
        composable(AppScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }

        composable(AppScreens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }

        composable(AppScreens.HomeScreen.name) {
            Home(navController = navController)
        }

        composable(AppScreens.UpdateScreen.name) {
            UpdateScreen(navController = navController)
        }

        composable(AppScreens.DetailsScreen.name) {
            DetailsScreen(navController = navController)
        }

        composable(AppScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }

        composable(AppScreens.StatisticsScreen.name) {
            StatsScreen(navController = navController)
        }
    }
}