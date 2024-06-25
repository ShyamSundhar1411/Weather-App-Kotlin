package com.example.jetweatherapp.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "favorite_tbl")
data class Favorite(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "country")
    val country: String
)
