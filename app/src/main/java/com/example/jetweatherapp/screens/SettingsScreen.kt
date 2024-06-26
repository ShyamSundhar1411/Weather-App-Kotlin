package com.example.jetweatherapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetweatherapp.components.WeatherAppBar
import com.example.jetweatherapp.model.MeasureUnit
import com.example.jetweatherapp.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(navController: NavController,
                   settingsViewModel: SettingsViewModel = hiltViewModel()
){
    val isCelsius = remember {
        mutableStateOf(false)
    }
    val choiceFromDb = settingsViewModel.unitList.collectAsState().value
    if (choiceFromDb.isNotEmpty()) {
        isCelsius.value = choiceFromDb[0].unit == "Celsius"
    }else{
        settingsViewModel.insertUnit(MeasureUnit("Celsius"))
        isCelsius.value = true
    }
    Scaffold(
        topBar = {
            WeatherAppBar(navController = navController,
                title = "Settings",
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                isMainScreen = false,
                onButtonClicked = {
                    navController.popBackStack()
                }
                )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.Start) {
                Row(
                    modifier = Modifier
                        .padding()
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "Temperature Units")
                    Spacer(modifier = Modifier.height(16.dp))
                    Switch(
                        checked = isCelsius.value,
                        onCheckedChange = { isChecked ->
                            isCelsius.value = isChecked
                        },
                        modifier = Modifier.padding(start = 8.dp)
                    )

                }
                Text(text = "Selected Units: ${if (isCelsius.value) "Celsius" else "Fahrenheit"}")
                Button(
                    onClick = {
                        settingsViewModel.insertUnit(if (isCelsius.value) MeasureUnit("Celsius") else MeasureUnit("Fahrenheit"))
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .padding(3.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(34.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFEFBE42),
                        contentColor = Color.White
                    )
                ){
                    Text("Save")
                }
            }
        }
    }
}