package com.example.jetweatherapp.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun formatDate(timestamp: Int): String {
    val sdf = SimpleDateFormat("EEE, MMM d", Locale.getDefault(Locale.Category.FORMAT))
    val date = java.util.Date(timestamp.toLong() * 1000)

    return sdf.format(date)
}

fun formatDateTime(timestamp: Int): String {
    val sdf = SimpleDateFormat("hh:mm:aa",Locale.getDefault(Locale.Category.FORMAT))
    val date = java.util.Date(timestamp.toLong() * 1000)

    return sdf.format(date)
}

fun formatDecimals(item: Double): String {
    return " %.0f".format(item)
}