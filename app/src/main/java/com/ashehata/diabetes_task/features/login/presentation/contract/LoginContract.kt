package com.ashehata.diabetes_task.features.login.presentation.contract

import com.ashehata.diabetes_task.base.BaseAction
import com.ashehata.diabetes_task.base.BaseIntent
import com.ashehata.diabetes_task.base.BaseViewState
import com.ashehata.diabetes_task.common.presentation.validation.InputWrapper
import com.ashehata.diabetes_task.common.presentation.validation.ValidationType

sealed class LoginIntent : BaseIntent {
    object OnLoginClicked : LoginIntent()
}

sealed class LoginAction : BaseAction {
    object OpenDiabetesScreen : LoginAction()
}

data class LoginViewState(
    val email: InputWrapper = InputWrapper(validationType = ValidationType.Email),
    val password: InputWrapper = InputWrapper(validationType = ValidationType.Password),
) : BaseViewState()