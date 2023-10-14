package com.ashehata.diabetes_task.features.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashehata.diabetes_task.common.presentation.util.GeneralObservers
import com.ashehata.diabetes_task.features.diabetes.presentation.composables.DiabetesScreen
import com.ashehata.diabetes_task.features.diabetes.presentation.nav.openDiabetes
import com.ashehata.diabetes_task.features.diabetes.presentation.viewmodel.DiabetesViewModel
import com.ashehata.diabetes_task.features.login.presentation.composables.LoginScreen
import com.ashehata.diabetes_task.features.login.presentation.nav.openLogin
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

            AppTheme {
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.background)
                        )
                    }

                    composable("login") {
                        val viewModel: LoginViewModel by viewModels()
                        LoginScreen(viewModel, navController)
                    }

                    composable("diabetes") {
                        val viewModel: DiabetesViewModel by viewModels()
                        DiabetesScreen(viewModel, navController)
                    }
                }
            }

            GeneralObservers<HomeState, HomeViewModel>(viewModel = viewModel) {
                when (it) {
                    HomeState.OpenDiabetesScreen -> { navController.openDiabetes() }
                    HomeState.OpenLoginScreen -> { navController.openLogin() }
                }
            }
        }
    }

}