package com.ashehata.diabetes_task.features.diabetes.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.ashehata.diabetes_task.common.presentation.util.GeneralObservers
import com.ashehata.diabetes_task.features.diabetes.presentation.contract.DiabetesAction
import com.ashehata.diabetes_task.features.diabetes.presentation.contract.DiabetesIntent
import com.ashehata.diabetes_task.features.diabetes.presentation.contract.DiabetesViewState
import com.ashehata.diabetes_task.features.diabetes.presentation.model.DrugUIModel
import com.ashehata.diabetes_task.features.diabetes.presentation.viewmodel.DiabetesViewModel

@Composable
fun DiabetesScreen(
    viewModel: DiabetesViewModel,
    navController: NavController,
) {

    val viewStates = remember {
        viewModel.viewStates ?: DiabetesViewState()
    }

    val drugs = remember {
        viewStates.drugs
    }

    val isRefreshing = remember {
        viewStates.isRefreshing
    }

    val userEmail = remember {
        viewStates.userEmail
    }

    val isLoading = remember {
        viewStates.isLoading
    }

    val isNetworkError = remember {
        viewStates.isNetworkError
    }

    val onDrugClicked: (DrugUIModel) -> Unit = remember {
        {
            viewModel.setEvent(DiabetesIntent.OnDrugClicked(it))
        }
    }

    val onRefresh = remember {
        {
            viewModel.setEvent(DiabetesIntent.RefreshScreen)
        }
    }

    DiabetesScreenContent(
        isRefreshing = isRefreshing.value,
        userEmail = userEmail.value,
        drugs = drugs,
        onDrugClicked = onDrugClicked,
        onRefresh = onRefresh,
        isLoading = isLoading.value,
        isNetworkError = isNetworkError.value
    )

    GeneralObservers<DiabetesAction, DiabetesViewModel>(viewModel = viewModel) {
        when (it) {
            is DiabetesAction.OpenDrugDetailsScreen -> {

            }
        }
    }

}