package com.example.jetweatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetweatherapp.routes.Routes
import com.example.jetweatherapp.screens.MainScreen
import com.example.jetweatherapp.screens.SplashScreen
import com.example.jetweatherapp.viewmodel.MainViewModel

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Routes.SplashScreen.name){
        composable(Routes.SplashScreen.name){
            SplashScreen(navController = navController)
        }
        composable(Routes.MainScreen.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navController,mainViewModel)
        }
    }
}