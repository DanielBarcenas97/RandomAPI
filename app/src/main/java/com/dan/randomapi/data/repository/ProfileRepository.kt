package com.dan.randomapi.data.repository

import com.dan.randomapi.data.model.ResponseRandom
import com.dan.randomapi.data.service.RandomService


class ProfileRepository {
    private val api = RandomService()

    suspend fun getProfiles() : List<ResponseRandom>?{
        return api.getRandomUser()
    }


}