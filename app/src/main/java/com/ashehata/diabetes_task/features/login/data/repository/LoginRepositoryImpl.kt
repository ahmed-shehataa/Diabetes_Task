package com.ashehata.diabetes_task.features.login.data.repository


import com.ashehata.diabetes_task.features.login.domain.repository.LoginRepository
import com.ashehata.diabetes_task.features.login.data.remote.LoginRemoteDataSource
import com.ashehata.diabetes_task.features.user.data.mapper.toDomainModel
import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource
) : LoginRepository {


    override suspend fun login(
        email: String,
        password: String,
    ): UserDomainModel {
        return loginRemoteDataSource.login(email, password).toDomainModel()
    }

}
