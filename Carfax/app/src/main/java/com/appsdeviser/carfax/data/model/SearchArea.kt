package com.appsdeviser.carfax.data.model

data class SearchArea(
    val city: String,
    val dynamicRadii: List<Double>,
    val dynamicRadius: Boolean,
    val latitude: Double,
    val longitude: Double,
    val radius: Double,
    val state: String,
    val zip: String
)