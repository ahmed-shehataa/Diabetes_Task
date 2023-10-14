package com.ashehata.diabetes_task.features.diabetes.data.local.source

import com.ashehata.diabetes_task.features.diabetes.data.model.DrugDataModel
import com.ashehata.orange_task.modules.news.data.local.dao.DiabetesDao
import javax.inject.Inject

class DiabetesLocalDataSourceImpl @Inject constructor(
    private val dao: DiabetesDao
) : DiabetesLocalDataSource {
    override fun getAllDrugs(): List<DrugDataModel> {
        return dao.getDrugs()
    }

    override suspend fun insert(drugs: List<DrugDataModel>) {
        dao.insertAll(drugs)
    }

    override suspend fun clearAll() {
        dao.deleteAll()
    }


}