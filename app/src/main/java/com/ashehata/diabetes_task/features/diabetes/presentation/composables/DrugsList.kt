package com.ashehata.diabetes_task.features.diabetes.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ashehata.diabetes_task.features.diabetes.presentation.model.DrugUIModel

@Composable
fun DrugsList(
    drugs: List<DrugUIModel>,
    onDrugClicked: (DrugUIModel) -> Unit,
) {

    LazyColumn(Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)) {

        items(drugs) {
            DrugItem(drug = it, onDrugClicked = onDrugClicked)
        }
    }

}