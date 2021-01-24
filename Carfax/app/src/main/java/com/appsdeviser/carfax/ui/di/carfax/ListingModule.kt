package com.appsdeviser.carfax.ui.di.carfax

import com.appsdeviser.carfax.domain.usecase.GetCarFaxDataUseCase
import com.appsdeviser.carfax.ui.listing.ListingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ListingModule {
    //TODO Complete this class

    @ListingScope
    @Provides
    fun provideListingViewModelFactory(
       getCarFaxDataUseCase: GetCarFaxDataUseCase
    ): ListingViewModelFactory {
        return ListingViewModelFactory(getCarFaxDataUseCase)
    }
}