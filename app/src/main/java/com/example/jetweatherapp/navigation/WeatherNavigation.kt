package com.example.jetweatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetweatherapp.routes.Routes
import com.example.jetweatherapp.screens.SplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Routes.SplashScreen.name){
        composable(Routes.SplashScreen.name){
            SplashScreen(navController = navController)
        }

    }
}