package com.appsdeviser.carfax.data.model

data class HistoryX(
    val city: String,
    val date: String,
    val description: String,
    val odometerReading: Int,
    val source: String,
    val state: String
)