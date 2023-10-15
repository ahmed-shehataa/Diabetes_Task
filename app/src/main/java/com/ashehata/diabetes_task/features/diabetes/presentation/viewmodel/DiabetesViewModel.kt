package com.ashehata.diabetes_task.features.diabetes.presentation.viewmodel

import com.ashehata.diabetes_task.base.BaseViewModel
import com.ashehata.diabetes_task.features.diabetes.domain.usecase.GetDrugsListUseCase
import com.ashehata.diabetes_task.features.diabetes.presentation.contract.DiabetesAction
import com.ashehata.diabetes_task.features.diabetes.presentation.contract.DiabetesIntent
import com.ashehata.diabetes_task.features.diabetes.presentation.contract.DiabetesViewState
import com.ashehata.diabetes_task.features.diabetes.presentation.mapper.toUIModel
import com.ashehata.diabetes_task.features.user.domain.usecase.GetUserUseCase
import com.ashehata.diabetes_task.features.user.domain.usecase.LogOutUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiabetesViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getDrugsListUseCase: GetDrugsListUseCase,
    private val logOutUserUseCase: LogOutUserUseCase
) : BaseViewModel<DiabetesIntent, DiabetesViewState, DiabetesAction>() {

    init {
        getUser()
        getDrugs()
    }

    private fun getUser() {
        launchCoroutine {
            viewStates?.userEmail?.value = getUserUseCase.execute().email
        }
    }

    private fun getDrugs() {
        launchCoroutine {
            viewStates?.let {
                it.drugs.clear()
                setLoading()
                it.drugs.addAll(getDrugsListUseCase.execute().map { it.toUIModel() })
                setDoneLoading()
            }
        }
    }

    override fun handleEvents(event: DiabetesIntent) {
        when (event) {
            is DiabetesIntent.OnDrugClicked -> {
                setState {
                    viewStates?.clickedDrug?.value = event.drugUIModel
                    DiabetesAction.OpenDrugDetailsScreen(event.drugUIModel)
                }
            }

            DiabetesIntent.RefreshScreen -> {
                getDrugs()
            }

            DiabetesIntent.OnLogoutClicked -> {
                launchCoroutine {
                    logOutUserUseCase.execute()
                    setState { DiabetesAction.OpenLoginScreen }
                }
            }
        }
    }

    override fun createInitialViewState(): DiabetesViewState {
        return DiabetesViewState()
    }
}