package com.appsdeviser.carfax.data.repository.carfax.datasource

import com.appsdeviser.carfax.data.model.CarFaxData

interface CarFaxLocalDataSource {
    suspend fun getCarFaxDataFromDB(): CarFaxData
    suspend fun saveCarFaxDataToDB(actors: CarFaxData)
    suspend fun clearAll()
}