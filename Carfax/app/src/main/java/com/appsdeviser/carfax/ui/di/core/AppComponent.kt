package com.appsdeviser.carfax.ui.di.core

import com.appsdeviser.carfax.ui.di.carfax.ListingSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun carFaxSubComponent(): ListingSubComponent.Factory
}