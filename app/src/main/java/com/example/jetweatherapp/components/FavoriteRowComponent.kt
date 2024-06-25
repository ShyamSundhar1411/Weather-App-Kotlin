package com.example.jetweatherapp.components

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetweatherapp.model.Favorite

@Composable
fun FavoriteRowComponent(favorite: Favorite, onDelete: (Favorite) -> Unit) {
    Surface(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2 .dp,color = Color.Black)


        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = favorite.city,
                modifier = Modifier.padding(start = 4.dp)
            )
            Text(
                text = favorite.country,
                modifier = Modifier.padding(start = 4.dp)
            )
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                modifier = Modifier.clickable {
                    onDelete(favorite)
                }
            )
        }
    }
}