package com.appsdeviser.carfax.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FirstPhoto(
    val large: String,
    val medium: String,
    val small: String
) : Parcelable