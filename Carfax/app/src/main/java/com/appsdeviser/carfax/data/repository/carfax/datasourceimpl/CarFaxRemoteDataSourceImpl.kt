package com.appsdeviser.carfax.data.repository.carfax.datasourceimpl

import com.appsdeviser.carfax.data.api.CarFaxService
import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxRemoteDataSource
import com.appsdeviser.carfax.data.xxx.CarFaxData
import retrofit2.Response

class CarFaxRemoteDataSourceImpl(
    private val carFaxService: CarFaxService
) : CarFaxRemoteDataSource {

    override suspend fun getCarFaxData(): Response<CarFaxData> = carFaxService.getCarFaxData()
}