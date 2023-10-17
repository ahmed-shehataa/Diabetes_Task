package com.ashehata.diabetes_task.features.diabetes.domain.usecase

import com.ashehata.diabetes_task.features.diabetes.domain.model.DrugDomainModel
import com.ashehata.diabetes_task.features.diabetes.domain.repository.DiabetesRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.times

class GetDrugsListUseCaseTest {

    private lateinit var diabetesRepository: DiabetesRepository
    private lateinit var getDrugsListUseCase: GetDrugsListUseCase

    @Before
    fun setUp() {
        diabetesRepository = Mockito.mock()
        getDrugsListUseCase = GetDrugsListUseCase(diabetesRepository)
    }


    @Test
    fun `execute should return a list of drugs`() = runBlocking {
        val expectedList = listOf(
            DrugDomainModel(name = "anatel", strength = "200", dose = "123"),
            DrugDomainModel(name = "xyz", strength = "50", dose = "123"),
            DrugDomainModel(name = "abc", strength = "125", dose = "123"),
        )

        Mockito.`when`(diabetesRepository.getDrugs()).thenReturn(expectedList)

        val result = getDrugsListUseCase.execute()

        Mockito.verify(diabetesRepository, times(1)).getDrugs()

        assertEquals(expectedList, result)
    }


}