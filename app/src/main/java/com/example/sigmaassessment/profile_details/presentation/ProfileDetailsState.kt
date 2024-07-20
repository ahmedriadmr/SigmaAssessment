package com.example.sigmaassessment.profile_details.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.example.sigmaassessment.profile_details.data.model.ProfileDataSet
@Parcelize
data class ProfileDetailsState(
    val data: ProfileDataSet = ProfileDataSet(),
): Parcelable
