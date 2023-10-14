package com.ashehata.diabetes_task.features.diabetes.presentation.nav

import androidx.navigation.NavController
import androidx.navigation.navOptions


fun NavController.openDiabetes() {
    navigate(
        "diabetes",
        navOptions = navOptions {
            popUpTo("login") {
                inclusive = true
            }
        }
    )
}