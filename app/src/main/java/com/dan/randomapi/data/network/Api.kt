package com.dan.randomapi.data.network

import com.dan.randomapi.data.model.ResponseRandom
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("?results=40")
    suspend fun getRandomUser(): Response<ResponseRandom>
}