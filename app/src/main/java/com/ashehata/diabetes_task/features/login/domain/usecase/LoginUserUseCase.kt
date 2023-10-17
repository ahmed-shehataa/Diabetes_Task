package com.ashehata.diabetes_task.features.login.domain.usecase

import com.ashehata.diabetes_task.features.login.domain.repository.LoginRepository
import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    suspend fun execute(
        email: String,
        password: String,
    ): UserDomainModel {
        return repository.login(email, password)
    }
}