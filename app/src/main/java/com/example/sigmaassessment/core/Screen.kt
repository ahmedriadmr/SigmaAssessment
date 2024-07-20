package com.example.sigmaassessment.core

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    data object Intro: Routes()

    @Serializable
    data object Profile: Routes()

    @Serializable
    data object ProfileDetails: Routes()
}