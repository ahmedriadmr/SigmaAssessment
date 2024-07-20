package com.example.sigmaassessment.profile_details.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sigmaassessment.R
import com.example.sigmaassessment.core.presentation.ObserveAsEvents
import com.example.sigmaassessment.profile_details.presentation.component.InfoSection
import com.example.sigmaassessment.profile_details.presentation.component.TopSectionDetails
import com.example.sigmaassessment.ui.component.MenuData
import com.example.sigmaassessment.ui.component.MenuItems
import com.example.sigmaassessment.ui.component.TopAppBar
import com.example.sigmaassessment.ui.theme.Red
import com.example.sigmaassessment.ui.theme.Teal

@Composable
fun ProfileDetailsScreen(navigationBarPadding: Dp, viewModel: ProfileDetailsViewModel = hiltViewModel(), onBackClick: () -> Unit) {
    val context = LocalContext.current
    ObserveAsEvents(flow = viewModel.events) { event ->
        when (event) {
            is ProfileDetailsEvent.Error -> {
                Toast.makeText(
                    context, event.error.asString(context), Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    ProfileDetailsContent(navigationBarPadding = navigationBarPadding, state = viewModel.state) { action ->
        when (action) {
            ProfileDetailsAction.OnBackClick -> onBackClick()
            ProfileDetailsAction.OnEditEmail -> TODO()
        }
    }
}

@Composable
fun ProfileDetailsContent(
    modifier: Modifier = Modifier,
    navigationBarPadding: Dp = 0.dp,
    state: ProfileDetailsState = ProfileDetailsState(),
    onAction: (ProfileDetailsAction) -> Unit = {}
) {

    Scaffold(modifier = modifier.padding(bottom = navigationBarPadding), topBar = {
        TopAppBar(drawable = R.drawable.profile_details_header,
            content = { statusBarSize -> TopSectionDetails(statusBarSize = statusBarSize, onAction = onAction) })
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InfoSection(state.data)
            MenuItems(modifier = modifier.padding(top = 8.dp), menuItems = menuItems())
        }
    }
}

@Composable
fun menuItems() = listOf(
    MenuData(painterResource(R.drawable.lock), stringResource(id = R.string.change_password)), MenuData(painterResource(R.drawable.logout), stringResource(id = R.string.logout), MaterialTheme.colorScheme.error, MaterialTheme.colorScheme.errorContainer, MaterialTheme.colorScheme.error)
)

@Preview(showBackground = true)
@Composable
fun PreviewProfileDetails() {
    MaterialTheme {
        ProfileDetailsContent()
    }
}