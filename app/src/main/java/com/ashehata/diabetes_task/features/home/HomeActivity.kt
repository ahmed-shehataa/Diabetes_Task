package com.ashehata.diabetes_task.features.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.ashehata.diabetes_task.common.presentation.util.GeneralObservers
import com.ashehata.diabetes_task.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            AppTheme {
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {}

                    composable("login") {
                        /* val viewModel: SignUpViewModel by viewModels()
                         SignUpScreen(viewModel, navController)*/
                    }

                    composable("diabetes") {
                        /* val viewModel: ProfileViewModel by viewModels()
                         ProfileScreen(viewModel, navController)*/
                    }


                }

            }

            GeneralObservers<HomeState, HomeViewModel>(viewModel = viewModel) {
                val navOptions = navOptions {
                    popUpTo("splash") {
                        inclusive = true
                    }
                }

                when (it) {
                    HomeState.OpenDiabetesScreen -> {
                        navController.navigate(
                            "diabetes",
                            navOptions = navOptions
                        )
                    }

                    HomeState.OpenLoginScreen -> {
                        navController.navigate(
                            "login",
                            navOptions = navOptions
                        )
                    }
                }
            }
        }
    }
}
