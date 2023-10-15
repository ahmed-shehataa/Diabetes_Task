package com.ashehata.diabetes_task.features.diabetes.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ashehata.diabetes_task.R
import com.ashehata.diabetes_task.features.diabetes.presentation.model.DrugUIModel

@Composable
fun DiabetesDetailsScreen(drug: DrugUIModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        drug.name?.let {
            ItemTitled(
                title = R.string.name,
                description = it
            )
        }

        drug.dose?.let {
            ItemTitled(
                title = R.string.dos,
                description = it
            )
        }

        drug.strength?.let {
            ItemTitled(
                title = R.string.strength,
                description = it
            )
        }

    }
}