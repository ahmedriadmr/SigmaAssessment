package com.example.sigmaassessment.profile_details.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // Enables code generation for better performance
data class ProfileDataSet(
    @Json(name = "serviceNumber") val serviceNumber: String = "",
    @Json(name = "customerId") val customerId: String = "",
    @Json(name = "customerName") val customerName: String = "",
    @Json(name = "address") val address: String = "",
    @Json(name = "email") val email: String = "",
    @Json(name = "pin1") val pin1: String = "",
    @Json(name = "pin2") val pin2: String = "",
    @Json(name = "puk1") val puk1: String = "",
    @Json(name = "puk2") val puk2: String = "",
    @Json(name = "postalCode") val postalCode: String = "",
    @Json(name = "certificateType") val certificateType: CertificateType = CertificateType(),
    @Json(name = "certificateId") val certificateId: String = "",
    @Json(name = "dateOfBirth") val dateOfBirth: String = "",
    @Json(name = "msg") val msg: String? = null
)
