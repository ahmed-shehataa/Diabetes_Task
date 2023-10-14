package com.ashehata.diabetes_task.features.diabetes.domain.usecase

import com.ashehata.diabetes_task.features.diabetes.domain.model.DrugDomainModel
import com.ashehata.diabetes_task.features.diabetes.domain.repository.DiabetesRepository
import javax.inject.Inject

class GetDrugsListUseCase @Inject constructor(
    private val repository: DiabetesRepository
) {

    suspend fun execute(): List<DrugDomainModel> {
        return repository.getDrugs()
    }
}