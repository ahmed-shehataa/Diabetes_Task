package com.ashehata.diabetes_task.features.diabetes.data.remote

import com.ashehata.diabetes_task.features.diabetes.data.model.DrugDataModel

interface DiabetesRemoteDataSource {

    suspend fun getDrugs(): List<DrugDataModel>
}