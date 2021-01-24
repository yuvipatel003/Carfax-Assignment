package com.appsdeviser.carfax.ui.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.appsdeviser.carfax.domain.usecase.GetCarFaxDataUseCase

class ListingViewModel(private val getCarFaxDataUseCase: GetCarFaxDataUseCase) : ViewModel() {

    /**
     * Get CarFaxData from Cache or API
     * @return - LiveData
     */
    fun getCarFaxData() = liveData {
        val newsList = getCarFaxDataUseCase.execute()
        emit(newsList)
    }
}