package com.example.jetweatherapp.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetweatherapp.model.Weather

@Composable
fun MainContent(data: Weather,modifier: Modifier) {
    Text(text = data.city.name)
}