package com.example.composereader.navigation

enum class AppScreens {
    SplashScreen,
    LoginScreen,
    NewUserScreen,
    HomeScreen,
    DetailsScreen,
    UpdateScreen,
    StatisticsScreen,
    SearchScreen;

    companion object {
        fun fromRoute(route: String?): AppScreens = when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            HomeScreen.name -> HomeScreen
            UpdateScreen.name -> UpdateScreen
            DetailsScreen.name -> DetailsScreen
            StatisticsScreen.name -> StatisticsScreen
            SearchScreen.name -> SearchScreen
            null -> LoginScreen
            else -> throw IllegalArgumentException("Route $route does not exist")
        }
    }
}