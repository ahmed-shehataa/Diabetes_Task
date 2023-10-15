package com.ashehata.diabetes_task.features.diabetes.data.remote

import com.ashehata.diabetes_task.features.diabetes.data.model.DrugDataModel
import com.ashehata.diabetes_task.features.diabetes.data.retrofit.service.DiabetesService
import javax.inject.Inject

class DiabetesRemoteDataSourceImpl @Inject constructor(
    private val service: DiabetesService
) : DiabetesRemoteDataSource {

    override suspend fun getDrugs(): List<DrugDataModel> {
        return service.getDiabetes().problems?.firstOrNull()
            ?.diabetes?.firstOrNull()
            ?.medications?.firstOrNull()
            ?.medicationsClasses?.firstOrNull()
            ?.let {
                val firstList: List<DrugDataModel>? =
                    it.className?.firstOrNull()?.drugDataModel
                        ?.plus(it.className.firstOrNull()?.drugDataModel2 ?: emptyList())

                val secondList: List<DrugDataModel>? =
                    it.className2?.firstOrNull()?.drugDataModel
                        ?.plus(it.className2.firstOrNull()?.drugDataModel2 ?: emptyList())

                return@let firstList?.plus(secondList ?: emptyList()) ?: emptyList()
            } ?: emptyList()
    }
}