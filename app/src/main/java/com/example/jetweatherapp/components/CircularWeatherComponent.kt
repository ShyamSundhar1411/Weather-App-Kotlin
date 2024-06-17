package com.example.jetweatherapp.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetweatherapp.model.Weather

@Composable
fun CircularWeatherComponent(modifier: Modifier = Modifier,weatherData: Weather){
    val imageUrl = "https://openweathermap.org/img/wn/${weatherData.list[0].weather[0].icon}.png"


    Text(
            text = "Nov 29",
            style = MaterialTheme.typography.labelLarge,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(6.dp)
        )
        Surface(
            modifier = modifier
                .padding(4.dp)
                .size(200.dp),
            shape = CircleShape,
            color = Color(0xFFFFC400)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherStateImage(
                    imageUrl = imageUrl
                )
                Text(
                    text = "56",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Rainy",
                    style = MaterialTheme.typography.displaySmall
                )
            }
        }


}