package com.appsdeviser.carfax.data.api

import com.appsdeviser.carfax.data.model.CarFax
import com.appsdeviser.carfax.data.xxx.CarFaxData
import retrofit2.Response
import retrofit2.http.GET

interface CarFaxService {
        @GET("assignment.json")
        suspend fun getCarFaxData(): Response<CarFaxData>
}