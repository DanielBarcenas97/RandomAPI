package com.dan.randomapi.domain

import com.dan.randomapi.data.model.ResultProfile
import com.dan.randomapi.data.repository.ProfileRepository

class ProfileUseCase {

    private val repository = ProfileRepository()

    suspend fun getAllProfiles() : List<ResultProfile>? {
        return repository.getProfiles()
    }

}