package com.appsdeviser.carfax.data.api

import com.appsdeviser.carfax.data.model.CarFaxData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("assignment.json")
    fun getCarFaxData(): Call<CarFaxData>

    companion object {

        var BASE_URL = "https://carfax-for-consumers.firebaseio.com/"

        fun create(): ApiInterface {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client =
                OkHttpClient.Builder().addInterceptor(interceptor).build()


            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}