package com.dan.randomapi.data.repository

import com.dan.randomapi.data.model.ResultProfile
import com.dan.randomapi.data.service.RandomService

class ProfileRepository {
    private val api = RandomService()

    suspend fun getProfiles() : List<ResultProfile>?{
        return api.getRandomUser()
    }

}