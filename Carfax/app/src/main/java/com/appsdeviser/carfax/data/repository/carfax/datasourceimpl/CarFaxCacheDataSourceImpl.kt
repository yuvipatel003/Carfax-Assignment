package com.appsdeviser.carfax.data.repository.carfax.datasourceimpl

import com.appsdeviser.carfax.data.model.CarFaxData
import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxCacheDataSource

class CarFaxCacheDataSourceImpl : CarFaxCacheDataSource {

    private var mCarFaxData: CarFaxData? = null
    override suspend fun getCarFaxDataFromCache(): CarFaxData {
        return mCarFaxData!!
    }

    override suspend fun saveCarFaxDataToCache(carFaxData: CarFaxData) {
        mCarFaxData = carFaxData
    }
}