package com.appsdeviser.carfax.data.model

data class SearchRequest(
    val make: String,
    val mileageRange: MileageRangeX,
    val priceRange: PriceRange,
    val radius: Int,
    val srpUrl: String,
    val webHost: String,
    val yearRange: YearRangeX,
    val zip: String
)