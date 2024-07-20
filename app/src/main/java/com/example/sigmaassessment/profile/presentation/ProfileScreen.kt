package com.example.sigmaassessment.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.sigmaassessment.R
import com.example.sigmaassessment.profile.presentation.component.TopSection
import com.example.sigmaassessment.ui.component.MenuData
import com.example.sigmaassessment.ui.component.MenuItems
import com.example.sigmaassessment.ui.component.TopAppBar

/** ViewModel has no use */

@Preview
@Composable
fun ProfileScreen(modifier: Modifier = Modifier, navigationBarPadding: Dp = 0.dp, onAction: (ProfileAction) -> Unit = {}) {

    Scaffold(modifier = modifier.padding(bottom = navigationBarPadding), topBar = {
        TopAppBar(
            drawable = R.drawable.profile_header,
            content = { statusBarSize -> TopSection(statusBarHeight = statusBarSize) }
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MenuItems(modifier.padding(top = 8.dp), menuItems(), onAction)
        }
    }
}

@Composable
fun menuItems() = listOf(
    MenuData(painterResource(R.drawable.item_user), stringResource(id = R.string.profile)),
    MenuData(painterResource(R.drawable.item_settings), stringResource(id = R.string.settings)),
    MenuData(painterResource(R.drawable.item_support), stringResource(id = R.string.support)),
    MenuData(painterResource(R.drawable.item_shop), stringResource(id = R.string.shop))
)

@Preview(showBackground = true)
@Composable
fun PreviewProfileDetails() {
    MaterialTheme {
        ProfileScreen()
    }
}
