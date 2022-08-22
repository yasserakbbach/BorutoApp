package com.yasserakbbach.borutoapp.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.yasserakbbach.borutoapp.R
import com.yasserakbbach.borutoapp.presentation.model.OnBoardingPage
import com.yasserakbbach.borutoapp.ui.theme.EXTRA_LARGE_PADDING
import com.yasserakbbach.borutoapp.ui.theme.PAGING_INDICATOR_SPACING
import com.yasserakbbach.borutoapp.ui.theme.PAGING_INDICATOR_WIDTH
import com.yasserakbbach.borutoapp.ui.theme.SMALL_PADDING
import com.yasserakbbach.borutoapp.ui.theme.WelcomeScreenActiveIndicatorColor
import com.yasserakbbach.borutoapp.ui.theme.WelcomeScreenBackgroundColor
import com.yasserakbbach.borutoapp.ui.theme.WelcomeScreenDescriptionColor
import com.yasserakbbach.borutoapp.ui.theme.WelcomeScreenFinishButtonColor
import com.yasserakbbach.borutoapp.ui.theme.WelcomeScreenInActiveIndicatorColor
import com.yasserakbbach.borutoapp.ui.theme.WelcomeScreenTitleColor

@ExperimentalPagerApi
@Composable
fun WelcomeScreen(navController: NavHostController) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WelcomeScreenBackgroundColor),
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10F),
            count = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top,
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1F)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = WelcomeScreenActiveIndicatorColor,
            inactiveColor = WelcomeScreenInActiveIndicatorColor,
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING,
        )
        FinishButton(
            modifier = Modifier.weight(1F),
            isVisible = pagerState.currentPage == pages.size.minus(1),
        ) {

        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(.5F)
                .fillMaxHeight(.7F),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(id = onBoardingPage.title)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = onBoardingPage.title),
            fontWeight = FontWeight.Bold,
            color = WelcomeScreenTitleColor,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = stringResource(id = onBoardingPage.description),
            color = WelcomeScreenDescriptionColor,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun FinishButton(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier.padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = isVisible
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = WelcomeScreenFinishButtonColor,
                    contentColor = Color.White,
                )
            ) {
                Text(text = stringResource(R.string.welcome_screen_finish_button))
            }
        }
    }
}