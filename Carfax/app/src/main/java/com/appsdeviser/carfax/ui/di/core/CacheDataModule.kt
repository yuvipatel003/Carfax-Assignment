package com.appsdeviser.carfax.ui.di.core

import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxCacheDataSource
import com.appsdeviser.carfax.data.repository.carfax.datasourceimpl.CarFaxCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideCarFaxCacheDataSource(): CarFaxCacheDataSource {
        return CarFaxCacheDataSourceImpl()
    }
}