package com.example.jetweatherapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetweatherapp.R
import com.example.jetweatherapp.model.WeatherItem

@Composable
fun HumidityWindPressureComponent(weatherData: WeatherItem){
    Row(
        modifier = Modifier.fillMaxWidth().padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(


        ) {
            Image(painter =
                painterResource(id = R.drawable.humidity)
                , contentDescription =  "Humidity",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "${weatherData.humidity}%",
                style = MaterialTheme.typography.labelSmall
            )

        }
        Row(){
            Image(painter =
            painterResource(id = R.drawable.pressure)
                , contentDescription =  "Pressure",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "${weatherData.pressure} psi",
                style = MaterialTheme.typography.labelSmall
            )
        }
        Row(){
            Image(painter =
            painterResource(id = R.drawable.wind)
                , contentDescription =  "Wind",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "${weatherData.sunrise} mph",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}