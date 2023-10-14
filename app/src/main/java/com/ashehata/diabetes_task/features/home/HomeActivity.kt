package com.ashehata.diabetes_task.features.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.ashehata.diabetes_task.R
import com.ashehata.diabetes_task.common.presentation.util.GeneralObservers
import com.ashehata.diabetes_task.features.diabetes.presentation.composables.DiabetesScreen
import com.ashehata.diabetes_task.features.diabetes.presentation.viewmodel.DiabetesViewModel
import com.ashehata.diabetes_task.features.login.presentation.composables.LoginScreen
import com.ashehata.diabetes_task.features.login.presentation.viewModel.LoginViewModel
import com.ashehata.diabetes_task.theme.AppTheme
import com.ashehata.diabetes_task.util.getCurrentTime
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val navController = rememberNavController()
            val navOptionsLogin = navOptions {
                popUpTo("splash") {
                    inclusive = true
                }
            }
            val navOptionsDiabetes = navOptions {
                popUpTo("login") {
                    inclusive = true
                }
            }
            val openDiabetes = remember {
                {
                    navController.navigate(
                        "diabetes",
                        navOptions = navOptionsDiabetes
                    )
                }
            }

            val openLogin = remember {
                {
                    navController.navigate(
                        "login",
                        navOptions = navOptionsLogin
                    )
                }
            }

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
                        LoginScreen(viewModel) {
                            Toast.makeText(
                                context,
                                getString(R.string.welcome) + it + "\n" + getCurrentTime(),
                                Toast.LENGTH_SHORT
                            ).show()
                            openDiabetes()
                        }
                    }

                    composable("diabetes") {
                        val viewModel: DiabetesViewModel by viewModels()
                        DiabetesScreen(viewModel, navController)
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
