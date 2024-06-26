package com.example.jetweatherapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetweatherapp.components.WeatherAppBar
import com.example.jetweatherapp.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(navController: NavController,
                   settingsViewModel: SettingsViewModel = hiltViewModel()
){
    Scaffold(
        topBar = {
            WeatherAppBar(navController = navController,
                title = "Settings",
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                isMainScreen = false,
                onButtonClicked = {
                    navController.popBackStack()
                }
                )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}