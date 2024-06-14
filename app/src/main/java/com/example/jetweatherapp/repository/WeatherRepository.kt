package com.example.jetweatherapp.repository

import com.example.jetweatherapp.data.DataOrException
import com.example.jetweatherapp.model.Weather
import com.example.jetweatherapp.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi){
    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception> {

        val response = try{
            api.getWeather(query = cityQuery)
        }catch (e: Exception){
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }
}