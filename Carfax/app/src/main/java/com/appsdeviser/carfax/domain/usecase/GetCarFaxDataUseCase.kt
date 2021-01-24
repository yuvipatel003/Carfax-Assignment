package com.appsdeviser.carfax.domain.usecase

import com.appsdeviser.carfax.data.xxx.CarFaxData
import com.appsdeviser.carfax.domain.repository.CarFaxRepository

class GetCarFaxDataUseCase(private val carFaxRepository: CarFaxRepository) {
    suspend fun execute(): CarFaxData? = carFaxRepository.getCarFaxData()
}