package com.example.sigmaassessment.profile_details.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class CertificateType(
    @Json(name = "ar") val ar: String? = "",
    @Json(name = "localized") val localized: String? = "",
    @Json(name = "en") val en: String? = "",
    @Json(name = "fr") val fr: String? = ""
) : Parcelable
