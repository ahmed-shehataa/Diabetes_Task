package com.ashehata.diabetes_task.features.diabetes.data.repository

import com.ashehata.diabetes_task.features.diabetes.data.local.source.DiabetesLocalDataSource
import com.ashehata.diabetes_task.features.diabetes.data.mapper.toDomainModel
import com.ashehata.diabetes_task.features.diabetes.data.remote.DiabetesRemoteDataSource
import com.ashehata.diabetes_task.features.diabetes.domain.model.DrugDomainModel
import com.ashehata.diabetes_task.features.diabetes.domain.repository.DiabetesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DiabetesRepositoryImpl @Inject constructor(
    private val remote: DiabetesRemoteDataSource,
    private val local: DiabetesLocalDataSource,
) : DiabetesRepository {


    override suspend fun getDrugs(): List<DrugDomainModel> = withContext(Dispatchers.IO) {
        /**
         *  we can add more logic here depending on our scenario
         *  like fore refreshing the data under some constraints or some rules
         *  so it depends on the scenario
         */
        if (local.getAllDrugs().isEmpty()) {
            val remoteList = remote.getDrugs()
            local.insert(remoteList)
        }
        return@withContext local.getAllDrugs().map { it.toDomainModel() }
    }


}