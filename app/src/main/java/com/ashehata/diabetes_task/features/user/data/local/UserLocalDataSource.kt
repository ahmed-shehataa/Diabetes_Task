package com.ashehata.diabetes_task.features.user.data.local

import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel


interface UserLocalDataSource {
    suspend fun getUser(): UserDomainModel
    suspend fun setUser(user: UserDomainModel)
    suspend fun clearUser()
    suspend fun checkIfUserLoggedIn(): Boolean
}