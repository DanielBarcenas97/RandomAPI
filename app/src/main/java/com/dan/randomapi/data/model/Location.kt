package com.dan.randomapi.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    @SerializedName("city")
    val city: String,
    @SerializedName("coordinates")
    val coordinates: Coordinates,
    @SerializedName("country")
    val country: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("street")
    val street: Street,
    @SerializedName("timezone")
    val timezone: Timezone
): Parcelable