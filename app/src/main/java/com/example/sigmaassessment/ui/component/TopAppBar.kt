package com.example.sigmaassessment.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp

@Composable
fun TopAppBar(modifier: Modifier = Modifier, @DrawableRes drawable: Int, content: @Composable (Dp) -> Unit) {
    val statusBarHeight = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    val backgroundImage: ImageVector = ImageVector.vectorResource(id = drawable)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(backgroundImage.defaultHeight + statusBarHeight),
            imageVector = backgroundImage,
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
        )

        content(statusBarHeight)
    }
}