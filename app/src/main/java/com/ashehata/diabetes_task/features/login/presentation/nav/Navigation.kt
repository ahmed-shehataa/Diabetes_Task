package com.ashehata.diabetes_task.features.login.presentation.nav

import androidx.navigation.NavController
import androidx.navigation.navOptions


fun NavController.openLogin(isFromDiabetes: Boolean) {
    navigate(
        "login",
        navOptions = navOptions {
            if (isFromDiabetes)
                popUpTo("diabetes") {
                    inclusive = true
                }
            else
                popUpTo("splash") {
                    inclusive = true
                }
        }
    )
}