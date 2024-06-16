package com.example.jetweatherapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun WeatherAppBar(
    modifier: Modifier = Modifier,
    title: String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
//    navController: NavController = null,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
    ){
    TopAppBar(title = {

        Text(text = title,

            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp

            ),
            )
    })
}