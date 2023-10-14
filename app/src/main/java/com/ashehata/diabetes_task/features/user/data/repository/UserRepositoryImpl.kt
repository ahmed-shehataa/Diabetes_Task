package com.ashehata.diabetes_task.features.user.data.repository

import com.ashehata.diabetes_task.features.user.data.local.UserLocalDataSource
import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel
import com.ashehata.diabetes_task.features.user.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
) : UserRepository {

    override suspend fun getUser(): UserDomainModel {
        return userLocalDataSource.getUser()
    }

    override suspend fun setUser(user: UserDomainModel) {
        return userLocalDataSource.setUser(user)
    }

    override suspend fun logoutUser() {
        return userLocalDataSource.clearUser()
    }

    override suspend fun checkIfUserLoggedIn(): Boolean {
        return userLocalDataSource.checkIfUserLoggedIn()
    }

}
