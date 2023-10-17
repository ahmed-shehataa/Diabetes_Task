package com.ashehata.diabetes_task.features.login.data.remote

import com.ashehata.diabetes_task.features.user.data.model.UserDataModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds


class LoginRemoteDataSourceImpl @Inject constructor() : LoginRemoteDataSource {

    override suspend fun login(
        email: String,
        password: String,
    ): UserDataModel {
        delay(2.5.seconds)
        return UserDataModel(email)
    }

}
