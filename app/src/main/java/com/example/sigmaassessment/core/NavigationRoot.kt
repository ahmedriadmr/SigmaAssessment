package com.example.sigmaassessment.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sigmaassessment.profile.presentation.ProfileAction
import com.example.sigmaassessment.profile.presentation.ProfileScreen
import com.example.sigmaassessment.profile_details.presentation.ProfileDetailsScreen

@Composable
fun NavigationRoot(
    navController: NavHostController,
    innerPadding: Dp,
) {
    NavHost(
        navController = navController, startDestination = Routes.Intro
    ) {
        profileGraph(navController, innerPadding)
    }
}

private fun NavGraphBuilder.profileGraph(navController: NavHostController, innerPadding: Dp) {
    navigation<Routes.Intro>(startDestination = Routes.Profile) {
        composable<Routes.Profile> {
            ProfileScreen(navigationBarPadding = innerPadding, onAction = { action ->
                when (action) {
                    is ProfileAction.OnProfileClicked -> when (action.route) {
                        Routes.Profile.toString() -> navController.navigate(Routes.ProfileDetails)
                    }
                }
            })
        }

        composable<Routes.ProfileDetails> {
            ProfileDetailsScreen(navigationBarPadding = innerPadding, onBackClick = { navController.navigateUp() })
        }
    }
}