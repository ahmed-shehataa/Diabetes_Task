package com.ashehata.diabetes_task.features.diabetes.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ashehata.diabetes_task.base.BaseAction
import com.ashehata.diabetes_task.base.BaseIntent
import com.ashehata.diabetes_task.base.BaseViewState
import com.ashehata.diabetes_task.features.diabetes.presentation.model.DrugUIModel

sealed class DiabetesIntent : BaseIntent {
    data class OnDrugClicked(val drugUIModel: DrugUIModel) : DiabetesIntent()
    object RefreshScreen : DiabetesIntent()
}

sealed class DiabetesAction : BaseAction {
    data class OpenDrugDetailsScreen(val drugUIModel: DrugUIModel) : DiabetesAction()
}

data class DiabetesViewState(
    val userEmail: MutableState<String> = mutableStateOf(""),
    val clickedDrug: MutableState<DrugUIModel?> = mutableStateOf(null),
    val drugs: SnapshotStateList<DrugUIModel> = mutableStateListOf(),
) : BaseViewState()
