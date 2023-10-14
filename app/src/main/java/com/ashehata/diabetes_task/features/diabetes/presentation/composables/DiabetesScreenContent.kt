package com.ashehata.diabetes_task.features.diabetes.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import com.ashehata.diabetes_task.R
import com.ashehata.diabetes_task.common.presentation.compose.NetworkErrorUI
import com.ashehata.diabetes_task.common.presentation.compose.ProgressLoading
import com.ashehata.diabetes_task.features.diabetes.presentation.model.DrugUIModel


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DiabetesScreenContent(
    userEmail: String,
    drugs: List<DrugUIModel>,
    isRefreshing: Boolean,
    isLoading: Boolean,
    isNetworkError: Boolean,
    onDrugClicked: (DrugUIModel) -> Unit,
    onRefresh: () -> Unit,
) {

    val refreshState = rememberPullRefreshState(isRefreshing, onRefresh)
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.drugs))
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),)
        },

        ) { scaffold ->

        Column(Modifier.padding(top = scaffold.calculateTopPadding())) {

            WelcomeHeader(userEmail)

            Box(Modifier.pullRefresh(refreshState)) {

                if (isLoading) {
                    ProgressLoading()
                } else if (isNetworkError) {
                    NetworkErrorUI(onTryClicked = onRefresh)
                } else
                    DrugsList(drugs, onDrugClicked)

                PullRefreshIndicator(
                    isRefreshing,
                    refreshState,
                    Modifier.align(Alignment.TopCenter)
                )
            }
        }


    }
}