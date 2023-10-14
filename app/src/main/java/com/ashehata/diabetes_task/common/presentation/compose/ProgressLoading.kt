package com.ashehata.diabetes_task.common.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProgressLoading() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            Modifier
                .size(35.dp)
                .align(Alignment.Center)
        )
    }
}