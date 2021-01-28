package com.appsdeviser.carfax.domain.repository

import com.appsdeviser.carfax.data.model.CarFaxData

interface CarFaxRepository {
    suspend fun getCarFaxData(): CarFaxData?
}