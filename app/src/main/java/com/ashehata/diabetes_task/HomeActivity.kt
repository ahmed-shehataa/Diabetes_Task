package com.ashehata.diabetes_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ashehata.diabetes_task.ui.theme.Diabetes_TaskTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Diabetes_TaskTheme {
               
            }
        }
    }
