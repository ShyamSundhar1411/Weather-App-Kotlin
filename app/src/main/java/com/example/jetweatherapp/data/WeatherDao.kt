package com.example.jetweatherapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetweatherapp.model.Favorite
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface WeatherDao {
    @Query("SELECT * from favorite_tbl")
    fun getFavorites(): Flow<List<Favorite>>
    @Query("SELECT * from favorite_tbl where city = :city")
    suspend fun getFavByCity(city: String): Favorite
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(favorite: Favorite)

    @Query("DELETE from favorite_tbl")
    suspend fun deleteAllFavorites()

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}