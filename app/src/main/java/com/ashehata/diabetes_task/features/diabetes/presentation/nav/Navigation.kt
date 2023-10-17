package com.ashehata.diabetes_task.features.diabetes.presentation.nav

import androidx.navigation.NavController
import androidx.navigation.navOptions


fun NavController.openDiabetes(isFromLogin: Boolean = true) {
    navigate(
        "diabetes",
        navOptions = navOptions {
            if (isFromLogin)
                popUpTo("login") {
                    inclusive = true
                }
            else
                popUpTo("splash") {
                    inclusive = true
                }
        }
    )
}