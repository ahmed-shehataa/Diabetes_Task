package com.ashehata.diabetes_task.features.diabetes.presentation.composables

import androidx.activity.compose.BackHandler
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ashehata.diabetes_task.common.presentation.util.GeneralObservers
import com.ashehata.diabetes_task.features.diabetes.presentation.contract.DiabetesAction
import com.ashehata.diabetes_task.features.diabetes.presentation.contract.DiabetesIntent
import com.ashehata.diabetes_task.features.diabetes.presentation.contract.DiabetesViewState
import com.ashehata.diabetes_task.features.diabetes.presentation.model.DrugUIModel
import com.ashehata.diabetes_task.features.diabetes.presentation.viewmodel.DiabetesViewModel
import com.ashehata.diabetes_task.features.login.presentation.nav.openLogin
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DiabetesScreen(
    viewModel: DiabetesViewModel = hiltViewModel(),
    navController: NavController
) {

    /**
     * UI States
     */
    val scope = rememberCoroutineScope()

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

    val clickedDrug = remember {
        viewStates.clickedDrug
    }

    val isNetworkError = remember {
        viewStates.isNetworkError
    }

    val logoutDialogState = remember {
        viewStates.logoutDialogState
    }

    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

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

    val onLogout = remember {
        {
            viewModel.setEvent(DiabetesIntent.OnLogoutClicked)
        }
    }

    /**
     * Handle back pressed
     */
    BackHandler(enabled = bottomSheetState.isVisible) {
        scope.launch {
            bottomSheetState.hide()
        }
    }

    /**
     * UI
     */
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = MaterialTheme.shapes.medium,
        sheetContent = {
            clickedDrug.value?.let {
                DiabetesDetailsScreen(it)
            }
        },
    ) {
        DiabetesScreenContent(
            isRefreshing = isRefreshing.value,
            userEmail = userEmail.value,
            drugs = drugs,
            logoutDialogState = logoutDialogState,
            onDrugClicked = onDrugClicked,
            onRefresh = onRefresh,
            isLoading = isLoading.value,
            isNetworkError = isNetworkError.value,
            onLogout = onLogout,
        )
    }


    /**
     * Listen to VM actions
     */
    GeneralObservers<DiabetesAction, DiabetesViewModel>(viewModel = viewModel) {
        when (it) {
            is DiabetesAction.OpenDrugDetailsScreen -> {
                scope.launch {
                    bottomSheetState.show()
                }
            }

            DiabetesAction.OpenLoginScreen -> {
                navController.openLogin(isFromDiabetes = true)
            }
        }
    }

}