package com.appsdeviser.carfax.ui.di.core

import android.content.Context
import com.appsdeviser.carfax.ui.di.carfax.ListingSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ListingSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}