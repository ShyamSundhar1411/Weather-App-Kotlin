package com.example.jetweatherapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetweatherapp.model.Favorite
import javax.inject.Singleton

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}