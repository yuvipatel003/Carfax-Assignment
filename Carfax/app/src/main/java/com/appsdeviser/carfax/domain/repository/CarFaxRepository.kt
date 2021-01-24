package com.appsdeviser.carfax.domain.repository

import com.appsdeviser.carfax.data.xxx.CarFaxData

interface CarFaxRepository {
    suspend fun getCarFaxData(): CarFaxData?
}