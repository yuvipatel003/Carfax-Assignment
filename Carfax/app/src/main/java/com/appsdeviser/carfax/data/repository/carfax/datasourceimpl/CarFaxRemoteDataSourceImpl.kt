package com.appsdeviser.carfax.data.repository.carfax.datasourceimpl

import com.appsdeviser.carfax.data.api.CarFaxService
import com.appsdeviser.carfax.data.model.CarFaxData
import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxRemoteDataSource
import retrofit2.Response

class CarFaxRemoteDataSourceImpl(
    private val carFaxService: CarFaxService
) : CarFaxRemoteDataSource {

    override suspend fun getCarFaxData(): Response<CarFaxData> = carFaxService.getCarFaxData()
}