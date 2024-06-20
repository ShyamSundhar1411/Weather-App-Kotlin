package com.example.jetweatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetweatherapp.routes.Routes
import com.example.jetweatherapp.screens.MainScreen
import com.example.jetweatherapp.screens.SearchScreen
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
        val route = Routes.MainScreen.name
        composable("$route/{city}",
            arguments = listOf(
                navArgument("city"){
                    type = NavType.StringType
                }
            )) {
            navBack -> navBack.arguments?.getString("city").let {
            val mainViewModel = hiltViewModel<MainViewModel>()
            if (it != null) {
                MainScreen(
                    navController = navController,
                    mainViewModel,
                    city = it
                )
            }
            }
        }
        composable(Routes.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
    }
}