package com.example.sigmaassessment.profile_details.domain

import com.example.sigmaassessment.core.domain.util.DataError
import com.example.sigmaassessment.core.domain.util.Result
import com.example.sigmaassessment.profile_details.data.ProfileRepository
import com.example.sigmaassessment.profile_details.data.model.ProfileDataSet
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(private val repository: ProfileRepository) {
    suspend operator fun invoke(): Result<ProfileDataSet, DataError.Network> {
        return repository.fetchProfile()
    }
}