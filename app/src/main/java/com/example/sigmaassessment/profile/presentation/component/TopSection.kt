package com.example.sigmaassessment.profile.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.coerceAtMost
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sigmaassessment.R

@Preview
@Composable
fun TopSection(modifier: Modifier = Modifier, statusBarHeight: Dp = 0.dp) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = statusBarHeight.coerceAtMost(24.dp))
            .wrapContentSize()
    ) {
        Text(
            modifier = Modifier.padding(top = 35.dp),
            text = stringResource(id = R.string.user_name),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp , color = MaterialTheme.colorScheme.onSecondary)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Text(modifier = modifier.padding(horizontal = 8.dp), text = stringResource(id = R.string.phone_number), color = MaterialTheme.colorScheme.onSecondary)
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.down_arrow), contentDescription = null)
        }

        Box(Modifier.padding(top = statusBarHeight)) {
            Image(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.user_circle),
                contentDescription = "Profile Icon",
            )
            Image(
                painter = painterResource(id = R.drawable.profile_icon),
                contentDescription = "Profile Icon",
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.Center)
            )
        }
    }
}