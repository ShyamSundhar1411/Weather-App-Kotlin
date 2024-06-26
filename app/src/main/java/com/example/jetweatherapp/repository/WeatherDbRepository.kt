package com.example.jetweatherapp.repository

import com.example.jetweatherapp.data.WeatherDao
import com.example.jetweatherapp.model.Favorite
import com.example.jetweatherapp.model.MeasureUnit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDbRepository @Inject constructor(private val weatherDao: WeatherDao) {
    fun getFavorites(): Flow<List<Favorite>> = weatherDao.getFavorites()
    suspend fun insertFavorite(favorite: Favorite) = weatherDao.insertFavorite(favorite)

    suspend fun updateFavorite(favorite: Favorite) = weatherDao.updateFavorite(favorite)

    suspend fun deleteAllFavorites() = weatherDao.deleteAllFavorites()

    suspend fun deleteFavorite(favorite: Favorite) = weatherDao.deleteFavorite(favorite)

    suspend fun getFavByCity(city: String) = weatherDao.getFavByCity(city)

    fun getMeasureUnits(): Flow<List<MeasureUnit>> = weatherDao.getMeasureUnits()

    suspend fun insertMeasureUnit(measureUnit: MeasureUnit) = weatherDao.insertMeasureUnit(measureUnit)

    suspend fun updateMeasureUnit(measureUnit:MeasureUnit) = weatherDao.updateMeasureUnit(measureUnit)

    suspend fun deleteAllMeasureUnits() = weatherDao.deleteAllMeasureUnits()

    suspend fun deleteMeasureUnit(measureUnit: MeasureUnit) = weatherDao.deleteMeasureUnit(measureUnit)

}