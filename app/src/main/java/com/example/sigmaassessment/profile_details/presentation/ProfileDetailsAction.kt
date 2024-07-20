package com.example.sigmaassessment.profile_details.presentation

sealed interface ProfileDetailsAction {
    data object OnBackClick: ProfileDetailsAction
    data object OnEditEmail: ProfileDetailsAction
}