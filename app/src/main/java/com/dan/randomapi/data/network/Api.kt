package com.dan.randomapi.data.network

import com.dan.randomapi.data.model.ResponseUserApi
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET
    suspend fun getRandomUser(): Response<ResponseUserApi>
}