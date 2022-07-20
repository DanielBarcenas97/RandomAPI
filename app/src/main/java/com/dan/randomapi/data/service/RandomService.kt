package com.dan.randomapi.data.service

import com.dan.randomapi.data.model.ResultProfile
import com.dan.randomapi.data.network.Api
import com.dan.randomapi.data.network.Retrofit

class RandomService {
    private val retrofit = Retrofit.getRetrofit()
    private val client = retrofit.create(Api::class.java)

    suspend fun getRandomUser() : List<ResultProfile>? = client.getRandomUser().body()?.results


}