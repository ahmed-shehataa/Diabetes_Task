package com.ashehata.diabetes_task.features.login.domain.usecase

import com.ashehata.diabetes_task.features.login.domain.repository.LoginRepository
import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.times

class LoginUserUseCaseTest {

    private lateinit var loginRepository: LoginRepository
    private lateinit var loginUserUseCase: LoginUserUseCase

    @Before
    fun setUp() {
        loginRepository = Mockito.mock()
        loginUserUseCase = LoginUserUseCase(loginRepository)
    }


    @Test
    fun `execute should return a UserDomainModel after success login`() = runBlocking {
        val email = "ahmed@gmail.com"
        val password = "123456789"

        val userDomainModel = UserDomainModel(email = email)
        Mockito.`when`(loginRepository.login(email, password)).thenReturn(userDomainModel)

        val result = loginUserUseCase.execute(email, password)

        Mockito.verify(loginRepository, times(1)).login(email, password)

        Assert.assertEquals(userDomainModel, result)
    }


}