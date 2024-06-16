package com.example.jetweatherapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest

@Composable
fun WeatherStateImage(imageUrl: String) {
    val painter = rememberAsyncImagePainter(model =
    ImageRequest.Builder(LocalContext.current).data(data = imageUrl).crossfade(true).build()
    )
    Image(modifier = Modifier.size(80.dp),
        painter = painter ,contentDescription = "Weather Image",
    )
}