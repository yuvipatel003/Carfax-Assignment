package com.appsdeviser.carfax.ui.di

import com.appsdeviser.carfax.ui.di.carfax.ListingSubComponent

interface Injector {
    fun createListingSubComponent(): ListingSubComponent
}