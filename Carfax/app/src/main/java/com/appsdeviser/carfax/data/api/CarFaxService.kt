package com.appsdeviser.carfax.data.api

import com.appsdeviser.carfax.data.model.CarFaxData
import retrofit2.Response
import retrofit2.http.GET

interface CarFaxService {
    @GET("assignment.json")
    suspend fun getCarFaxData(): Response<CarFaxData>
}