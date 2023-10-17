package com.ashehata.diabetes_task.features.login.di


import com.ashehata.diabetes_task.features.login.data.remote.LoginRemoteDataSource
import com.ashehata.diabetes_task.features.login.data.remote.LoginRemoteDataSourceImpl
import com.ashehata.diabetes_task.features.login.data.repository.LoginRepositoryImpl
import com.ashehata.diabetes_task.features.login.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class LoginModule {

    @ViewModelScoped
    @Binds
    abstract fun bindsLoginRepo(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

    @ViewModelScoped
    @Binds
    abstract fun bindsLoginRemoteDataSource(loginRemoteDataSourceImpl: LoginRemoteDataSourceImpl): LoginRemoteDataSource

}
