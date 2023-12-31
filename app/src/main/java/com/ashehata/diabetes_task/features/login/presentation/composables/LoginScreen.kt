package com.ashehata.diabetes_task.features.login.presentation.composables

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ashehata.diabetes_task.R
import com.ashehata.diabetes_task.common.presentation.util.GeneralObservers
import com.ashehata.diabetes_task.features.diabetes.presentation.nav.openDiabetes
import com.ashehata.diabetes_task.features.login.presentation.contract.LoginAction
import com.ashehata.diabetes_task.features.login.presentation.contract.LoginIntent
import com.ashehata.diabetes_task.features.login.presentation.contract.LoginViewState
import com.ashehata.diabetes_task.features.login.presentation.viewModel.LoginViewModel
import com.ashehata.diabetes_task.util.getCurrentTime

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val context = LocalContext.current

    val keyboardController = LocalSoftwareKeyboardController.current

    val viewStates = remember {
        viewModel.viewStates ?: LoginViewState()
    }


    val email = remember {
        viewStates.email
    }

    val password = remember {
        viewStates.password
    }

    val isLoading = remember {
        viewStates.isLoading
    }

    val isButtonEnabled by remember(email.text, password.text) {
        derivedStateOf {
            email.isValid.value && password.isValid.value
        }
    }

    val onLoginClicked = remember {
        {
            keyboardController?.hide()
            viewModel.setEvent(
                LoginIntent.OnLoginClicked
            )
        }
    }


    LoginScreenContent(
        isLoading = isLoading.value,
        email = email,
        password = password,
        isButtonEnabled = isButtonEnabled,
        onLoginClicked = onLoginClicked
    )

    GeneralObservers<LoginAction, LoginViewModel>(viewModel = viewModel) {
        when (it) {
            is LoginAction.OpenDiabetesScreen -> {
                Toast.makeText(
                    context,
                    String.format(
                        context.getString(R.string.welcome),
                        it.userEmail
                    ) + "\n" + getCurrentTime(),
                    Toast.LENGTH_SHORT
                ).show()

                navController.openDiabetes(isFromLogin = true)
            }
        }

    }
}