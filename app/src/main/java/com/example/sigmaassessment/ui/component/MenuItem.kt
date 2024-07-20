package com.example.sigmaassessment.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sigmaassessment.R
import com.example.sigmaassessment.profile.presentation.ProfileAction
import com.example.sigmaassessment.ui.theme.Blue
import com.example.sigmaassessment.ui.theme.Purple

@Composable
fun MenuItem(
    iconPainter: Painter, text: String, iconColor: Color, containerColor: Color, textColor: Color, onAction: (ProfileAction) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onAction(ProfileAction.OnProfileClicked(text)) })
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) { // Background drawable
        Box(modifier = Modifier.fillMaxWidth(.94f)) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.profile_button),
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
            )

            // Menu content (icons and text)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center),
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .padding(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.blue_hexagon),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        tint = containerColor
                    )
                    Icon(
                        painter = iconPainter, contentDescription = text, modifier = Modifier.align(Alignment.Center), tint = iconColor
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .wrapContentHeight(), text = text, color = textColor
                )
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.next),
            contentDescription = "Next",
            modifier = Modifier.size(24.dp),
            tint = Color.Unspecified
        )
    }
}

@Composable
fun MenuItems(modifier: Modifier = Modifier, menuItems: List<MenuData>, onAction: (ProfileAction) -> Unit = {}) {
    LazyColumn(modifier = modifier, contentPadding = PaddingValues(horizontal = 24.dp)) {
        items(menuItems, key = { item -> item.text }) { item ->
            MenuItem(item.iconPainter, item.text, item.iconColor, item.containerColor, item.textColor, onAction = onAction)
        }
    }
}

data class MenuData(
    val iconPainter: Painter,
    val text: String,
    val iconColor: Color = Purple,
    val containerColor: Color = Blue,
    val textColor: Color = Color.Black
)