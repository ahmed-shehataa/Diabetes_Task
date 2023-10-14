package com.ashehata.diabetes_task.features.user.domain.usecase

import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel
import com.ashehata.diabetes_task.features.user.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun execute(user: UserDomainModel) {
        userRepository.setUser(user)
    }
}