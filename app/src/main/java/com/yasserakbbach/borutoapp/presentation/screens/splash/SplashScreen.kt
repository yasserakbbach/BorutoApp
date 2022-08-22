package com.yasserakbbach.borutoapp.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.yasserakbbach.borutoapp.R
import com.yasserakbbach.borutoapp.ui.theme.Purple500
import com.yasserakbbach.borutoapp.ui.theme.Purple700

@Composable
fun SplashScreen(navController: NavHostController) {
    val rotationDegree = remember { Animatable(0F) }
    LaunchedEffect(key1 = true) {
        rotationDegree.animateTo(
            targetValue = 360F,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200,
            )
        )
    }
    Splash(rotationDegree.value)
}

@Composable
fun Splash(rotationDegree: Float) {
    Box(
        modifier = Modifier
            .properBackgroundColor(isSystemInDarkTheme())
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.rotate(degrees = rotationDegree),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.app_logo_description),
        )
    }
}

private fun Modifier.properBackgroundColor(isDarkMode: Boolean): Modifier =
    if(isDarkMode)
        then(background(Color.Black))
    else
        then(
            background(
                brush = Brush.verticalGradient(
                    colors = listOf(Purple700, Purple500),
                )
            )
        )

/**
 * To test with dark mode in preview use:
 * @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
 */
@Preview
@Composable
fun Preview() {
    Splash(1F)
}