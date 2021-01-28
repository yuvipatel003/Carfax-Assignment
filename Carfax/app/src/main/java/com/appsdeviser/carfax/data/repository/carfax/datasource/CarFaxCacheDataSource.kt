package com.appsdeviser.carfax.data.repository.carfax.datasource

import com.appsdeviser.carfax.data.model.CarFaxData

interface CarFaxCacheDataSource {
    suspend fun getCarFaxDataFromCache(): CarFaxData
    suspend fun saveCarFaxDataToCache(carFaxData: CarFaxData)
}