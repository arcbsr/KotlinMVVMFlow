package com.example.kotlinmvvmflow.di

import com.example.kotlinmvvmflow.model.DataApiRepository
import com.example.kotlinmvvmflow.model.DataApiRepositoryImpl
import com.example.kotlinmvvmflow.remot.MovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideClearScoreRepository(dataSource: MovieDataSource) : DataApiRepository {
        return DataApiRepositoryImpl(dataSource)
    }
}