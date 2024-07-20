package com.example.sigmaassessment.profile_details.data

import com.example.sigmaassessment.profile_details.data.model.ProfileDataSet
import retrofit2.Response
import retrofit2.http.POST

interface ApiService {

    @POST("api-gateway/mobilis-customer-management/customer/profile")
    suspend fun profile(): Response<ProfileDataSet>
}
