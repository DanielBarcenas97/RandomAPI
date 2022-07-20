package com.dan.randomapi.domain

import com.dan.randomapi.data.model.ResultProfile
import com.dan.randomapi.data.repository.ProfileRepository

class ProfileUseCase(private val userRepository: ProfileRepository) {

    suspend operator fun invoke() : List<ResultProfile>? = userRepository.getProfiles()

}