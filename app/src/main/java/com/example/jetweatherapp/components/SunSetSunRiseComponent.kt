package com.example.jetweatherapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetweatherapp.R
import com.example.jetweatherapp.model.WeatherItem
import com.example.jetweatherapp.utils.formatDateTime

@Composable
fun SunSetSunRiseComponent(weatherData: WeatherItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(){
            Image(painter =
            painterResource(id = R.drawable.sunrise)
                , contentDescription =  "Wind",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = formatDateTime(weatherData.sunrise),
                style = MaterialTheme.typography.labelSmall
            )
        }
        Row {
            Image(painter =
            painterResource(id = R.drawable.sunset)
                , contentDescription =  "Wind",
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = formatDateTime(weatherData.sunset),
                style = MaterialTheme.typography.labelSmall
            )
        }

    }
}