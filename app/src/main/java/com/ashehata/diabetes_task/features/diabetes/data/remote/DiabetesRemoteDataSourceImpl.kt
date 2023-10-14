package com.ashehata.diabetes_task.features.diabetes.data.remote

import com.ashehata.diabetes_task.features.diabetes.data.model.DrugDataModel
import com.ashehata.diabetes_task.features.diabetes.data.retrofit.service.DiabetesService
import javax.inject.Inject

class DiabetesRemoteDataSourceImpl @Inject constructor(
    private val service: DiabetesService
) : DiabetesRemoteDataSource {

    override suspend fun getDrugs(): List<DrugDataModel> {
        return emptyList()
    }
}