package com.dan.randomapi.data.model


import com.google.gson.annotations.SerializedName

data class ResponseUserApi(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)