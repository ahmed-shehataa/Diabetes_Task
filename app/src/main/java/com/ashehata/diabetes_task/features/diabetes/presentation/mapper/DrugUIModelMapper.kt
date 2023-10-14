package com.ashehata.diabetes_task.features.diabetes.presentation.mapper

import com.ashehata.diabetes_task.features.diabetes.domain.model.DrugDomainModel
import com.ashehata.diabetes_task.features.diabetes.presentation.model.DrugUIModel


fun DrugDomainModel.toUIModel() = DrugUIModel(
    dose, name, strength
)
