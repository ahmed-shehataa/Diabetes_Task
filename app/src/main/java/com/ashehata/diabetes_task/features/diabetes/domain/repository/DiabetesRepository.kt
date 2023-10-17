package com.ashehata.diabetes_task.features.diabetes.domain.repository

import com.ashehata.diabetes_task.features.diabetes.domain.model.DrugDomainModel

interface DiabetesRepository {

    suspend fun getDrugs(): List<DrugDomainModel>
}