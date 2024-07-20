package com.example.sigmaassessment.profile_details.data

import com.example.sigmaassessment.core.data.safeCall
import com.example.sigmaassessment.core.domain.util.DataError
import com.example.sigmaassessment.core.domain.util.Result
import com.example.sigmaassessment.profile_details.data.model.ProfileDataSet
import javax.inject.Inject

interface ProfileRepository {
    suspend fun fetchProfile(): Result<ProfileDataSet,DataError.Network>
}

class ProfileRepositoryRemote @Inject constructor(private val apiService: ApiService): ProfileRepository {

    override suspend fun fetchProfile(): Result<ProfileDataSet, DataError.Network> {
       return safeCall { apiService.profile() }
    }
}