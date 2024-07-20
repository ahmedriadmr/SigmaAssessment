package com.example.sigmaassessment.profile.presentation

sealed interface ProfileAction {
    class OnProfileClicked(val route: String) : ProfileAction
}