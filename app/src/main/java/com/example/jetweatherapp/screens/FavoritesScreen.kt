package com.example.jetweatherapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetweatherapp.components.FavoriteRowComponent
import com.example.jetweatherapp.components.WeatherAppBar
import com.example.jetweatherapp.viewmodel.FavoriteViewModel

@Composable
fun FavoritesScreen(navController: NavController,
                    favoriteViewModel: FavoriteViewModel = hiltViewModel()){
    Scaffold(
        topBar = {
            WeatherAppBar(navController = navController,
                title = "Favorite Cities",
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                isMainScreen = false,
                onButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxWidth()){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                val list = favoriteViewModel.favList.collectAsState().value
                LazyColumn {
                    items(items = list){favorite ->
                        FavoriteRowComponent(favorite, onDelete = {favoriteViewModel.deleteFavorite(favorite)})
                    }
                }

            }
        }
    }
}