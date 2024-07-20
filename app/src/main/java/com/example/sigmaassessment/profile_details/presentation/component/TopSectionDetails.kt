package com.example.sigmaassessment.profile_details.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sigmaassessment.R
import com.example.sigmaassessment.profile_details.presentation.ProfileDetailsAction

@Preview
@Composable
fun TopSectionDetails(modifier: Modifier = Modifier, statusBarSize: Dp = 0.dp, onAction: (ProfileDetailsAction) -> Unit = {}) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = statusBarSize.coerceAtLeast(48.dp))
    ) {
        Icon(painter = painterResource(id = R.drawable.nav_back),
            tint = Color.Unspecified,
            contentDescription = "back",
            modifier = Modifier
                .padding(start = 24.dp)
                .clickable { onAction(ProfileDetailsAction.OnBackClick) })


        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.my_profile),
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 24.sp)
        )
    }
}