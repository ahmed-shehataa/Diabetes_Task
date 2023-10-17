package com.ashehata.diabetes_task.features.user.di

import com.ashehata.diabetes_task.features.user.data.local.UserLocalDataSource
import com.ashehata.diabetes_task.features.user.data.local.UserLocalDataSourceImpl
import com.ashehata.diabetes_task.features.user.data.repository.UserRepositoryImpl
import com.ashehata.diabetes_task.features.user.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Singleton
    @Binds
    abstract fun bindsUserRepo(userRepositoryImpl: UserRepositoryImpl): UserRepository


    @Singleton
    @Binds
    abstract fun bindsUserLocalDataSourceImpl(userLocalDataSourceImpl: UserLocalDataSourceImpl): UserLocalDataSource

}