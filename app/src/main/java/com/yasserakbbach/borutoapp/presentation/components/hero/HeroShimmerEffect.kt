package com.yasserakbbach.borutoapp.presentation.components.hero

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.yasserakbbach.borutoapp.ui.theme.ABOUT_PLACEHOLDER_HEIGHT
import com.yasserakbbach.borutoapp.ui.theme.EXTRA_SMALL_PADDING
import com.yasserakbbach.borutoapp.ui.theme.HERO_ITEM_HEIGHT
import com.yasserakbbach.borutoapp.ui.theme.HeroItemNameShimmerBackgroundColor
import com.yasserakbbach.borutoapp.ui.theme.HeroItemShimmerBackgroundColor
import com.yasserakbbach.borutoapp.ui.theme.LARGE_PADDING
import com.yasserakbbach.borutoapp.ui.theme.MEDIUM_PADDING
import com.yasserakbbach.borutoapp.ui.theme.NAME_PLACEHOLDER_HEIGHT
import com.yasserakbbach.borutoapp.ui.theme.RATING_PLACEHOLDER_SIZE
import com.yasserakbbach.borutoapp.ui.theme.SMALL_PADDING

@Composable
fun HeroShimmerEffect() {
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING),
    ) {
        items(2) {
            AnimatedHeroShimmerItem()
        }
    }
}

@Composable
fun AnimatedHeroShimmerItem() {
    val transition = rememberInfiniteTransition()
    val alphaAnim by transition.animateFloat(
        initialValue = 1F,
        targetValue = 0F,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = FastOutLinearInEasing,
            ),
            repeatMode = RepeatMode.Reverse,
        )
    )
    HeroShimmerItem(alpha = alphaAnim)
}

@Composable
fun HeroShimmerItem(
    alpha: Float,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(HERO_ITEM_HEIGHT),
        color = HeroItemShimmerBackgroundColor,
        shape = RoundedCornerShape(size = LARGE_PADDING)
    ) {
        Column(
            modifier = Modifier.padding(all = MEDIUM_PADDING),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Surface(
                modifier = Modifier
                    .alpha(alpha)
                    .fillMaxWidth(.5F)
                    .height(NAME_PLACEHOLDER_HEIGHT),
                color = HeroItemNameShimmerBackgroundColor,
                shape = RoundedCornerShape(size = SMALL_PADDING),
            ) {}
            Spacer(modifier = Modifier.padding(SMALL_PADDING))
            repeat(3) {
                Surface(
                    modifier = Modifier
                        .alpha(alpha)
                        .fillMaxWidth()
                        .height(ABOUT_PLACEHOLDER_HEIGHT),
                    color = HeroItemNameShimmerBackgroundColor,
                    shape = RoundedCornerShape(size = SMALL_PADDING),
                ) {}
                Spacer(modifier = Modifier.padding(EXTRA_SMALL_PADDING))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                repeat(5) {
                    Surface(
                        modifier = Modifier
                            .alpha(alpha)
                            .size(RATING_PLACEHOLDER_SIZE),
                        color = HeroItemNameShimmerBackgroundColor,
                        shape = RoundedCornerShape(size = EXTRA_SMALL_PADDING),
                    ) {}
                    Spacer(modifier = Modifier.padding(EXTRA_SMALL_PADDING))
                }
            }
        }
    }
}