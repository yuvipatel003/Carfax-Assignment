package com.appsdeviser.carfax.ui.di.core

import com.appsdeviser.carfax.data.api.CarFaxService
import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxRemoteDataSource
import com.appsdeviser.carfax.data.repository.carfax.datasourceimpl.CarFaxRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideCarFaxRemoteDataSource(carFaxService: CarFaxService): CarFaxRemoteDataSource {
        return CarFaxRemoteDataSourceImpl(carFaxService)
    }
}