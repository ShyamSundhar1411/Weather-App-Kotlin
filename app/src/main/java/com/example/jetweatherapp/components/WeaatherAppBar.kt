package com.example.jetweatherapp.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetweatherapp.model.Favorite
import com.example.jetweatherapp.routes.Routes
import com.example.jetweatherapp.viewmodel.FavoriteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherAppBar(
    modifier: Modifier = Modifier,
    title: String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController,
    favoriteViewModel: FavoriteViewModel = hiltViewModel(),
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
    ){
    val showDialogBox = remember {
        mutableStateOf(false)
    }
    if (showDialogBox.value) {
        ShowDropDownMenu(showDialog = showDialogBox, navController = navController)
    }
    val showIt = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
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
                  IconButton(onClick = {
                      showDialogBox.value = !showDialogBox.value
                  }) {
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
            if (isMainScreen) {
                val isAlreadyFavorited = favoriteViewModel.favList.collectAsState().value.filter {
                    (it.city == title.split(',')[0])

                }
                if(isAlreadyFavorited.isEmpty()) {
                    Icon(imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite Icon",
                        modifier = Modifier
                            .padding(2.dp)
                            .scale(0.9f)
                            .clickable {

                                val city = title.split(',')[0]
                                val country = title.split(',')[1]
                                favoriteViewModel.insertFavorite(
                                    Favorite(
                                        city = city,
                                        country = country
                                    )
                                ).run {
                                    showIt.value = true
                                }

                            }
                    )
                }
                else{
                    showIt.value = false
                    Box(modifier = Modifier.padding(2.dp))
                }
                ShowToastComponent(context = context,showIt,message = "City Added To Favorites")
            }
        },

    )
}

@Composable
fun ShowDropDownMenu(showDialog: MutableState<Boolean>, navController: NavController) {
    val expanded = remember {
        mutableStateOf(true)
    }
    val items = listOf(
        mapOf(
            "About" to Icons.Default.Info,
            "Favorites" to Icons.Default.Favorite,
            "Settings" to Icons.Default.Settings,
        )
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
            .padding(top = 45.dp, end = 20.dp)

    ) {
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = {
                expanded.value = false

            },
            modifier = Modifier
                .width(160.dp)
                .background(Color.White)
        ) {

            items.forEach { item ->
                item.forEach { (label, icon) ->
                    DropdownMenuItem(text = {
                        Row {
                            Icon(imageVector = icon, contentDescription = label,
                                tint = Color.LightGray)
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = label,

                            )
                        }
                    }, onClick = {
                        expanded.value = false
                        showDialog.value = false
                        navController.navigate(
                            when(label){
                                "About" -> Routes.AboutScreen.name
                                "Favorites" -> Routes.FavoritesScreen.name
                                else -> Routes.SettingsScreen.name
                            })
                    })
                }
            }
        }

    }
}


