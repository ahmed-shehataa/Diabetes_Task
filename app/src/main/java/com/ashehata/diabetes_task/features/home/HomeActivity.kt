package com.ashehata.diabetes_task.features.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.ashehata.diabetes_task.common.presentation.util.GeneralObservers
import com.ashehata.diabetes_task.features.login.presentation.composables.LoginScreen
import com.ashehata.diabetes_task.features.login.presentation.viewModel.LoginViewModel
import com.ashehata.diabetes_task.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navOptions = navOptions {
                popUpTo("splash") {
                    inclusive = true
                }
            }
            val openDiabetes = remember {
                {
                    navController.navigate(
                        "diabetes",
                        navOptions = navOptions
                    )
                }
            }

            val openLogin = remember {
                {
                    navController.navigate(
                        "login",
                        navOptions = navOptions
                    )
                }
            }

            AppTheme {
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {}

                    composable("login") {
                        val viewModel: LoginViewModel by viewModels()
                        LoginScreen(viewModel) {
                            openDiabetes()
                        }
                    }

                    composable("diabetes") {
                        Text("diabetes")
                        /* val viewModel: ProfileViewModel by viewModels()
                         ProfileScreen(viewModel, navController)*/
                    }
                }
            }

            GeneralObservers<HomeState, HomeViewModel>(viewModel = viewModel) {
                when (it) {
                    HomeState.OpenDiabetesScreen -> { openDiabetes() }
                    HomeState.OpenLoginScreen -> { openLogin() }
                }
            }
        }
    }
}
