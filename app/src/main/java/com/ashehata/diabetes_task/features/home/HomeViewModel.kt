package com.ashehata.diabetes_task.features.home

import com.ashehata.diabetes_task.base.BaseIntent
import com.ashehata.diabetes_task.base.BaseViewModel
import com.ashehata.diabetes_task.features.user.domain.usecase.CheckUserIsLoggedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val checkUserIsLoggedInUseCase: CheckUserIsLoggedInUseCase,
) : BaseViewModel<BaseIntent, HomeViewState, HomeState>() {


    init {
        launchCoroutine {
            val isLoggedIn = checkUserIsLoggedInUseCase.execute()
            setState {
                if (isLoggedIn) HomeState.OpenDiabetesScreen else HomeState.OpenLoginScreen
            }
        }
    }

    override fun handleEvents(event: BaseIntent) {

    }

    override fun createInitialViewState(): HomeViewState {
        return HomeViewState()
    }

}
