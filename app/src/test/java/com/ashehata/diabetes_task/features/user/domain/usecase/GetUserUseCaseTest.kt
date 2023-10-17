package com.ashehata.diabetes_task.features.user.domain.usecase

import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel
import com.ashehata.diabetes_task.features.user.domain.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.times

class GetUserUseCaseTest {

    private lateinit var userRepository: UserRepository
    private lateinit var getUserUseCase: GetUserUseCase

    @Before
    fun setUp() {
        userRepository = Mockito.mock()
        getUserUseCase = GetUserUseCase(userRepository)
    }


    @Test
    fun `execute should return a UserDomainModel`() = runBlocking {
            val email = "ahmed@gmail.com"
            val userDomainModel = UserDomainModel(email = email)
            Mockito.`when`(userRepository.getUser()).thenReturn(userDomainModel)

            val result = getUserUseCase.execute()

            Mockito.verify(userRepository, times(1)).getUser()

            Assert.assertEquals(userDomainModel, result)
        }


}