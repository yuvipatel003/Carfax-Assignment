package com.appsdeviser.carfax.data.xxx

data class CarFaxData(
    val backfillCount: Int,
    val dealerNewCount: Int,
    val dealerUsedCount: Int,
    val enhancedCount: Int,
    val listings: List<Listings>,
    val page: Int,
    val pageSize: Int,
    val searchArea: SearchArea,
    val totalListingCount: Int,
    val totalPageCount: Int
)