package com.example.jetweatherapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetweatherapp.components.ShowData
import com.example.jetweatherapp.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavController,
               mainViewModel: MainViewModel = hiltViewModel()){
    Box(
       modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

    ) {
        ShowData(mainViewModel = mainViewModel)
    }

}


