package com.ashehata.diabetes_task.features.diabetes.data.repository

import com.ashehata.diabetes_task.features.diabetes.domain.model.DrugDomainModel
import com.ashehata.diabetes_task.features.diabetes.domain.repository.DiabetesRepository
import com.ashehata.diabetes_task.features.diabetes.data.local.source.DiabetesLocalDataSource
import com.ashehata.diabetes_task.features.diabetes.data.remote.DiabetesRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DiabetesRepositoryImpl @Inject constructor(
    private val remote: DiabetesRemoteDataSource,
    private val local: DiabetesLocalDataSource,
    //private val networkConnectivity: NetworkConnectivity
) : DiabetesRepository {


    override suspend fun getDrugs(): List<DrugDomainModel> = withContext(Dispatchers.IO) {
        /*if (networkConnectivity.isNetworkAvailable()) {
            if (page == 1)
                local.clearAllNews()

            val remoteNews = remote.getNews(page, perPage, keyword)
            local.insertNews(remoteNews)
        }

        val localNews = local.getAllNews(page = page, perPage = perPage, keyword = keyword)
            .map { it.toDomainModel() }
        // Hint: Throw IOException to notify the UI (to display ERROR view) becase there is some data but now local data is empty
        if (localNews.isEmpty() && networkConnectivity.isNetworkAvailable()
                .not()
        ) throw IOException()
        return@withContext localNews*/

        delay(2000)
        return@withContext List(20) {
            DrugDomainModel(
                name = "ahmed" + it,
                dose = "152",
                strength = "500"
            )
        }
    }


}