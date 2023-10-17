package com.ashehata.diabetes_task.util

import androidx.compose.runtime.Composable


@Composable
fun String?.CallIfValid(call: @Composable (String) -> Unit) {
    if (this.isNullOrEmpty().not())
        call(this!!)
}