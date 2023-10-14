package com.ashehata.diabetes_task.features.login.presentation.nav

import androidx.navigation.NavController
import androidx.navigation.navOptions


fun NavController.openLogin() {
    navigate(
        "login",
        navOptions = navOptions {
            popUpTo("splash") {
                inclusive = true
            }
        }
    )
}