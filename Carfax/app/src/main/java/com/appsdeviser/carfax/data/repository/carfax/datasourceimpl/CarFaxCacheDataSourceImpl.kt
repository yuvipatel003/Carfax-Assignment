package com.appsdeviser.carfax.data.repository.carfax.datasourceimpl

import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxCacheDataSource
import com.appsdeviser.carfax.data.xxx.CarFaxData

class CarFaxCacheDataSourceImpl : CarFaxCacheDataSource {

    private var mCarFaxData : CarFaxData? = null
    override suspend fun getCarFaxDataFromCache(): CarFaxData {
        return mCarFaxData!!
    }

    override suspend fun saveCarFaxDataToCache(carFaxData: CarFaxData) {
        mCarFaxData = carFaxData
    }
}