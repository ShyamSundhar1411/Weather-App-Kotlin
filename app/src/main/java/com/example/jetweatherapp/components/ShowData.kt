package com.example.jetweatherapp.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import com.example.jetweatherapp.data.DataOrException
import com.example.jetweatherapp.model.Weather
import com.example.jetweatherapp.viewmodel.MainViewModel

@Composable
fun ShowData(mainViewModel: MainViewModel) {
    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true),
    ) {
        value = mainViewModel.getWeatherData(city = "Seattle")

    }.value
    if(weatherData.loading == true){
        CircularProgressIndicator()
    }else if(weatherData.data != null){
        Text(text = "Main: ${weatherData.data!!.city.country}")
    }

}