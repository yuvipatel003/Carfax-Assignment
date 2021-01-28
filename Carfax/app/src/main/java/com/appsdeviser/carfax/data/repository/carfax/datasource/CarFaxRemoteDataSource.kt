package com.appsdeviser.carfax.data.repository.carfax.datasource

import com.appsdeviser.carfax.data.model.CarFaxData
import retrofit2.Response

interface CarFaxRemoteDataSource {
    suspend fun getCarFaxData(): Response<CarFaxData>
}