package com.ashehata.diabetes_task.features.login.presentation.viewModel

import com.ashehata.diabetes_task.base.BaseViewModel
import com.ashehata.diabetes_task.features.login.domain.usecase.LoginUserUseCase
import com.ashehata.diabetes_task.features.login.presentation.contract.LoginAction
import com.ashehata.diabetes_task.features.login.presentation.contract.LoginIntent
import com.ashehata.diabetes_task.features.login.presentation.contract.LoginViewState
import com.ashehata.diabetes_task.features.user.domain.usecase.SetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val setUserUseCase: SetUserUseCase,
    private val loginUserUseCase: LoginUserUseCase,
) : BaseViewModel<LoginIntent, LoginViewState, LoginAction>() {


    override fun handleEvents(event: LoginIntent) {
        when (event) {
            LoginIntent.OnLoginClicked -> {
                login()
            }
        }
    }


    private fun login() {
        setLoading()
        launchCoroutine {
            val user = loginUserUseCase.execute(
                viewStates?.email?.text?.value?.trim() ?: "",
                viewStates?.password?.text?.value ?: "",
            )
            setUserUseCase.execute(user)
            setDoneLoading()
            setState { LoginAction.OpenDiabetesScreen(user.email) }
        }
    }

    override fun createInitialViewState(): LoginViewState {
        return LoginViewState()
    }

}
