package com.appsdeviser.carfax.data.repository.carfax.datasource

import com.appsdeviser.carfax.data.xxx.CarFaxData

interface CarFaxCacheDataSource {
    suspend fun getCarFaxDataFromCache(): CarFaxData
    suspend fun saveCarFaxDataToCache(carFaxData: CarFaxData)
}