package com.ashehata.diabetes_task.features.user.domain.repository

import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel


interface UserRepository {
    suspend fun getUser(): UserDomainModel
    suspend fun setUser(user: UserDomainModel)
    suspend fun logoutUser()
    suspend fun checkIfUserLoggedIn(): Boolean
}
