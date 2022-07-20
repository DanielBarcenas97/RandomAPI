package com.dan.randomapi.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ResultProfile(
    @SerializedName("cell")
    var cell: String,
    @SerializedName("dob")
    var dob: Dob,
    @SerializedName("email")
    var email: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("location")
    var location: Location,
    @SerializedName("login")
    var login: Login,
    @SerializedName("name")
    var name: Name,
    @SerializedName("nat")
    var nat: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("picture")
    var picture: Picture,
    @SerializedName("registered")
    var registered: Registered
): Parcelable