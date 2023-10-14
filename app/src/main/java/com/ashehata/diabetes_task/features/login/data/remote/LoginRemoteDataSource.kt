package com.ashehata.diabetes_task.features.login.data.remote

import com.ashehata.diabetes_task.features.user.data.model.UserDataModel


interface LoginRemoteDataSource {

    suspend fun login(
        email: String,
        password: String,
    ): UserDataModel

}