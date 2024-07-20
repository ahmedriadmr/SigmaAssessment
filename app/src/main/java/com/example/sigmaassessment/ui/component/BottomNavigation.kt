package com.example.sigmaassessment.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.sigmaassessment.R


@Composable
fun BottomNavigation() {
    val items = listOf(
        BottomNavItem(stringResource(id = R.string.home), R.drawable.home),
        BottomNavItem(stringResource(id = R.string.services), R.drawable.service),
        BottomNavItem(stringResource(id = R.string.rewards), R.drawable.rewards),
        BottomNavItem(stringResource(id = R.string.more), R.drawable.more)
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .systemBarsPadding()
            .height(76.dp)
            .padding(start = 16.dp, end =  16.dp, bottom = 16.dp)
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(50), clip = true)
            .border(
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary), shape = RoundedCornerShape(50)
            )
    ) {
        val selectedIndex = remember { mutableIntStateOf(0) }

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconRes), contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.inverseSurface,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.inverseSurface,
                ),
                alwaysShowLabel = true,
                selected = selectedIndex.intValue == index,
                onClick = { selectedIndex.intValue = index },
                modifier = Modifier.padding(0.dp).then(
                    if (selectedIndex.intValue == index) {
                        Modifier.underlineDecoration(color = MaterialTheme.colorScheme.secondary)
                    } else {
                        Modifier
                    }
                )
            )
        }
    }
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.underlineDecoration(
    color: Color, strokeWidth: Dp = 1.dp // Default to half the typical stroke width
) = composed {
    val strokeWidthPx = with(LocalDensity.current) { strokeWidth.toPx() }
    Modifier.drawBehind {
        val underlineY = size.height - 8.dp.toPx() // Center vertically
        val halfWidth = size.width / 2
        val start = Offset(halfWidth - 16.dp.toPx() / 2, underlineY)
        val end = Offset(halfWidth + 16.dp.toPx() / 2, underlineY)
        drawLine(color, start, end, strokeWidthPx)
    }
}

data class BottomNavItem(val title: String, val iconRes: Int)

// Previews to see the Bottom Navigation Bar
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigation()
}