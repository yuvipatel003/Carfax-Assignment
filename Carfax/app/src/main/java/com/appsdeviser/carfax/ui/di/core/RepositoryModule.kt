package com.appsdeviser.carfax.ui.di.core

import com.appsdeviser.carfax.data.repository.carfax.CarFaxRepositoryImpl
import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxCacheDataSource
import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxRemoteDataSource
import com.appsdeviser.carfax.domain.repository.CarFaxRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideCarFaxRepository(
        carFaxRemoteDataSource: CarFaxRemoteDataSource,
        carFaxCacheDataSource: CarFaxCacheDataSource
    ): CarFaxRepository {
        return CarFaxRepositoryImpl(
            carFaxRemoteDataSource,
            carFaxCacheDataSource
        )
    }
}