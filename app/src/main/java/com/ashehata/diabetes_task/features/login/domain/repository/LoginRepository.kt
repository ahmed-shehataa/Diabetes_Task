package com.ashehata.diabetes_task.features.login.domain.repository

import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel


interface LoginRepository {

    suspend fun login(email: String, password: String): UserDomainModel

}