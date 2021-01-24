package com.appsdeviser.carfax.ui

import android.app.Application
import com.appsdeviser.carfax.BuildConfig
import com.appsdeviser.carfax.ui.di.Injector
import com.appsdeviser.carfax.ui.di.carfax.ListingSubComponent
import com.appsdeviser.carfax.ui.di.core.*


class App : Application(), Injector {


    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()
    }


    override fun createListingSubComponent(): ListingSubComponent {
        return appComponent.carFaxSubComponent().create()
    }
}