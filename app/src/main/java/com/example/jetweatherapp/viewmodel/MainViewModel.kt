package com.example.jetweatherapp.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetweatherapp.data.DataOrException
import com.example.jetweatherapp.model.Weather
import com.example.jetweatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {
    val data: MutableState<DataOrException<Weather, Boolean, Exception>>
     = mutableStateOf(DataOrException(null,true,Exception("")))

    init{
        loadWeather()
    }

    private fun loadWeather() {
        getWeather()
    }

    private fun getWeather(city: String = "Seattle") {
        viewModelScope.launch {
            if (city.isEmpty()) return@launch
            data.value.loading = true
            data.value = repository.getWeather(cityQuery = city)
            if (data.value.data.toString().isNotEmpty()) data.value.loading = false
        }
        Log.d("TAG", "getWeather: ${data.value.data.toString()}")

    }

}