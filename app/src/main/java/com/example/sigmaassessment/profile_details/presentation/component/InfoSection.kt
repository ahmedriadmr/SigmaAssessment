package com.example.sigmaassessment.profile_details.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sigmaassessment.R
import com.example.sigmaassessment.profile_details.data.model.ProfileDataSet
import com.example.sigmaassessment.ui.theme.Cyan

@Preview
@Composable
fun InfoSection(state: ProfileDataSet = ProfileDataSet()) {
    Box(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(id = R.string.profile_information), fontWeight = FontWeight.Normal, fontSize = 14.sp, color = Color.Gray)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .border(width = 1.dp, color = Cyan, shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                InfoRow(label = stringResource(id = R.string.name), value = state.customerName)
                InfoRow(label = stringResource(id = R.string.service_number), value = state.serviceNumber)
                InfoRow(label = stringResource(id = R.string.address), value = state.address)
                InfoRow(label = stringResource(id = R.string.email), value = state.email, isEditable = true)
            }
        }
    }
}


@Composable
fun InfoRow(label: String, value: String, isEditable: Boolean = false) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp), horizontalAlignment = Alignment.Start
    ) {
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = value, fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.Black)
            if (isEditable) {
                Icon(painter = painterResource(id = R.drawable.item_pencil),
                    tint = Color.Unspecified,
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .padding(start = 10.dp)
                        .clickable { /* Handle edit click */ })
            }
        }
    }
}