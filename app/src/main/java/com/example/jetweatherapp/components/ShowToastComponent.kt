package com.example.jetweatherapp.components

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun ShowToastComponent(context: Context, showIt: MutableState<Boolean>,message: String){
    if (showIt.value){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}