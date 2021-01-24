package com.appsdeviser.carfax.ui.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.appsdeviser.carfax.domain.usecase.GetCarFaxDataUseCase

class ListingViewModelFactory(private val getCarFaxDataUseCase: GetCarFaxDataUseCase) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListingViewModel(
            getCarFaxDataUseCase
        ) as T
    }
}