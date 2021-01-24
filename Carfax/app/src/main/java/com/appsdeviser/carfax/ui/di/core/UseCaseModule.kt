package com.appsdeviser.carfax.ui.di.core

import com.appsdeviser.carfax.domain.repository.CarFaxRepository
import com.appsdeviser.carfax.domain.usecase.GetCarFaxDataUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetCarFaxDataUseCase(carFaxRepository : CarFaxRepository): GetCarFaxDataUseCase {
        return GetCarFaxDataUseCase(carFaxRepository)
    }
}