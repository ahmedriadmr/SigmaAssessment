package com.example.sigmaassessment.profile_details.presentation

import com.example.sigmaassessment.ui.UiText

sealed interface ProfileDetailsEvent {
    data class Error(val error: UiText): ProfileDetailsEvent
}