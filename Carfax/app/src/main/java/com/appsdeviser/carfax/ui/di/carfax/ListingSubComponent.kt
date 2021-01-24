package com.appsdeviser.carfax.ui.di.carfax

import com.appsdeviser.carfax.ui.listing.MainActivity
import dagger.Subcomponent

@ListingScope
@Subcomponent(modules = [ListingModule::class])
interface ListingSubComponent {
    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ListingSubComponent
    }
}