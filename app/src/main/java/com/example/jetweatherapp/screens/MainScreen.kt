package com.example.jetweatherapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetweatherapp.components.MainScaffold
import com.example.jetweatherapp.components.MainScaffold
import com.example.jetweatherapp.data.DataOrException
import com.example.jetweatherapp.model.Weather
import com.example.jetweatherapp.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavController,
               mainViewModel: MainViewModel = hiltViewModel(),
               city: String = "Seattle"
               ){
    Box(
       modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

    ) {
        val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
            initialValue = DataOrException(loading = true),
        ) {
            value = mainViewModel.getWeatherData(city = city)

        }.value
        if(weatherData.loading == true){
            CircularProgressIndicator()
        }else if(weatherData.data != null){
            MainScaffold(weatherData.data!!, navController)
        }

    }

}


