package com.example.jetweatherapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.navigation.NavController
import com.example.jetweatherapp.R
import com.example.jetweatherapp.components.WeatherAppBar

@Composable
fun AboutScreen(navController: NavController){
    Scaffold(
        topBar = {
            WeatherAppBar(
                title = "About",
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                isMainScreen = false,
                navController = navController
            )
        }
    ) {
        Column(modifier =
        Modifier
            .fillMaxSize()
            .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
           Text(text = stringResource(id = R.string.about_app),
               style = MaterialTheme.typography.bodyLarge,
               fontWeight = FontWeight.Bold
               )
            Text(text = stringResource(id = R.string.api),
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light
                )
        }
    }
}