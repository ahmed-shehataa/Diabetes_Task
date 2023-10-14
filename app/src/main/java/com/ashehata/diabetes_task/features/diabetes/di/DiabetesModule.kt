package com.ashehata.orange_task.modules.Diabetes.di

import com.ashehata.diabetes_task.database.room.AppDatabase
import com.ashehata.diabetes_task.features.diabetes.data.local.source.DiabetesLocalDataSource
import com.ashehata.diabetes_task.features.diabetes.data.local.source.DiabetesLocalDataSourceImpl
import com.ashehata.diabetes_task.features.diabetes.data.remote.DiabetesRemoteDataSource
import com.ashehata.diabetes_task.features.diabetes.data.remote.DiabetesRemoteDataSourceImpl
import com.ashehata.diabetes_task.features.diabetes.data.repository.DiabetesRepositoryImpl
import com.ashehata.diabetes_task.features.diabetes.data.retrofit.service.DiabetesService
import com.ashehata.diabetes_task.features.diabetes.domain.repository.DiabetesRepository
import com.ashehata.orange_task.modules.news.data.local.dao.DiabetesDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class DiabetesModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDiabetesRemoteDataSource(diabetesRemoteDataSourceImpl: DiabetesRemoteDataSourceImpl): DiabetesRemoteDataSource


    @Binds
    @ViewModelScoped
    abstract fun bindDiabetesLocalDataSource(diabetesLocalDataSourceImpl: DiabetesLocalDataSourceImpl): DiabetesLocalDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindDiabetesRepository(diabetesRepoImpl: DiabetesRepositoryImpl): DiabetesRepository


    companion object {
        @ViewModelScoped
        @Provides
        fun provideDiabetesService(retrofit: Retrofit): DiabetesService =
            retrofit.create(DiabetesService::class.java)


        @ViewModelScoped
        @Provides
        fun provideDiabetesDao(appDatabase: AppDatabase): DiabetesDao = appDatabase.diabetesDao()

    }
}