package com.ashehata.diabetes_task.features.diabetes.data.local.source

import com.ashehata.diabetes_task.features.diabetes.data.model.DrugDataModel

interface DiabetesLocalDataSource {

    fun getAllDrugs(): List<DrugDataModel>

    suspend fun insert(drugs: List<DrugDataModel>)

    suspend fun clearAll()

}