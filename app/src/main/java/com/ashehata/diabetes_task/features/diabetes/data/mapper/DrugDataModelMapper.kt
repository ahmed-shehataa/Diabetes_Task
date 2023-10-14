package com.ashehata.diabetes_task.features.diabetes.data.mapper

import com.ashehata.diabetes_task.features.diabetes.data.model.DrugDataModel
import com.ashehata.diabetes_task.features.diabetes.domain.model.DrugDomainModel

fun DrugDataModel.toDomainModel() = DrugDomainModel(
    dose, name, strength
)