package com.ashehata.diabetes_task.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getCurrentTime(): String {
    val currentTime = Date()
    val dateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return dateFormat.format(currentTime)
}