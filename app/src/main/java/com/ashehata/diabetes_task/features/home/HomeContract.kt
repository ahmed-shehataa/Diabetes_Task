package com.ashehata.diabetes_task.features.home

import com.ashehata.diabetes_task.base.BaseAction
import com.ashehata.diabetes_task.base.BaseViewState


sealed class HomeState : BaseAction {
    object OpenLoginScreen : HomeState()
    object OpenDiabetesScreen : HomeState()
}

class HomeViewState : BaseViewState()