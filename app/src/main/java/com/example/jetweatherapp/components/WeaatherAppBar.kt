package com.example.jetweatherapp.components


import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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
@Composable
fun WeatherAppBar(
    modifier: Modifier = Modifier,
    title: String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
    ){
    TopAppBar(
        title = {

        Text(text = title,

            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp

            ),
            )
        },
        actions = {
              if(isMainScreen){
                  IconButton(onClick = { onAddActionClicked.invoke() }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                  }
                  IconButton(onClick = { onButtonClicked.invoke()}) {
                      Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "More")
                  }
              }
        },
        navigationIcon = {
                         if(icon != null){
                             Icon(imageVector = icon, contentDescription = null,
                                    modifier = Modifier.clickable {
                                        onButtonClicked.invoke()
                                    }
                                 )
                         }
        },

    )
}