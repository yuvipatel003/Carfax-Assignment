package com.appsdeviser.carfax.data.repository.carfax

import android.util.Log
import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxCacheDataSource
import com.appsdeviser.carfax.data.repository.carfax.datasource.CarFaxRemoteDataSource
import com.appsdeviser.carfax.data.xxx.CarFaxData
import com.appsdeviser.carfax.domain.repository.CarFaxRepository

class CarFaxRepositoryImpl(
    private val carFaxRemoteDataSource: CarFaxRemoteDataSource,
    private val carFaxCacheDataSource: CarFaxCacheDataSource
) : CarFaxRepository{
    // TODO : Complete this class

    private val mTAG = CarFaxRepositoryImpl::class.java.simpleName

    override suspend fun getCarFaxData(): CarFaxData? {
        return getCarFaxDataFromCache()
    }

    private suspend fun getCarFaxDataFromCache(): CarFaxData? {
        var mCarFaxData : CarFaxData? = null

        try {
            mCarFaxData = carFaxCacheDataSource.getCarFaxDataFromCache()
        } catch (e: Exception) {
            Log.d(mTAG, "Exception : $e")
        }

        if (mCarFaxData != null) {
            return mCarFaxData
        } else {
            mCarFaxData = getCarFaxDataFromAPI()
            carFaxCacheDataSource.saveCarFaxDataToCache(mCarFaxData!!)
        }
        return mCarFaxData
    }

    private suspend fun getCarFaxDataFromAPI(): CarFaxData? {
        var mCarFaxData : CarFaxData? = null

        try {
            val response = carFaxRemoteDataSource.getCarFaxData()
            mCarFaxData = response.body() ?: null
        } catch (e: Exception) {
            Log.d(mTAG, "Exception : $e")
            return null
        }
        return mCarFaxData
    }


}