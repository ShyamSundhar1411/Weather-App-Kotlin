package com.example.jetweatherapp.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.jetweatherapp.data.DataOrException
import com.example.jetweatherapp.model.Weather
import com.example.jetweatherapp.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(weather: Weather,navController: NavController) {
    Scaffold(topBar = {
        WeatherAppBar(title = weather.city.name + ", ${weather.city.country}")
    }
    ) {
        MainContent(data = weather,modifier = Modifier.padding(it).fillMaxWidth())
    }
}