package com.dan.randomapi.data.service

import com.dan.randomapi.data.model.ResponseUserApi
import com.dan.randomapi.data.network.Api
import com.dan.randomapi.data.network.Retrofit
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RandomService(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    private val retrofit = Retrofit.getRetrofit()
    private val client = retrofit.create(Api::class.java)


    suspend fun getRandomUser() : ResponseUserApi?{
        return withContext(dispatcher){
            val response = client.getRandomUser()
            response.body()
        }
    }
}