package com.example.jetweatherapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetweatherapp.components.SearchFormComponent
import com.example.jetweatherapp.components.WeatherAppBar
import com.example.jetweatherapp.routes.Routes

@Composable
fun SearchScreen(navController: NavController){
    Scaffold(
        topBar = {
            WeatherAppBar(
                title = "Search",
                navController = navController,
                isMainScreen = false,
                icon = Icons.AutoMirrored.Filled.ArrowBack,
            ){
                navController.popBackStack()
            }
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
         Column(
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {
             SearchFormComponent(modifier = Modifier.padding(16.dp)
                 .fillMaxWidth()
                 .align(Alignment.CenterHorizontally),
             ){city->

                 navController.navigate(Routes.MainScreen.name+"/$city")
             }
         }
        }
    }
}


