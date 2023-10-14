package com.ashehata.diabetes_task.features.diabetes.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ashehata.diabetes_task.R
import com.ashehata.diabetes_task.features.diabetes.presentation.model.DrugUIModel

@Composable
fun DrugItem(
    drug: DrugUIModel,
    onDrugClicked: (DrugUIModel) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .border(color = Color.Gray, shape = RoundedCornerShape(8.dp), width = 1.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.LightGray)
            .clickable {
                onDrugClicked(drug)
            }
            .padding(8.dp),
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