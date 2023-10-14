package com.ashehata.diabetes_task.features.user.domain.usecase

import com.ashehata.diabetes_task.features.user.domain.repository.UserRepository
import javax.inject.Inject

class LogOutUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun execute() {
        userRepository.logoutUser()
    }
}
