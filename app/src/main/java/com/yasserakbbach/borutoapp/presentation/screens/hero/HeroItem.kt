package com.yasserakbbach.borutoapp.presentation.screens.hero

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.yasserakbbach.borutoapp.R
import com.yasserakbbach.borutoapp.domain.model.Hero
import com.yasserakbbach.borutoapp.navigation.Screen
import com.yasserakbbach.borutoapp.presentation.components.rating.RatingWidget
import com.yasserakbbach.borutoapp.ui.theme.HERO_ITEM_HEIGHT
import com.yasserakbbach.borutoapp.ui.theme.LARGE_PADDING
import com.yasserakbbach.borutoapp.ui.theme.MEDIUM_PADDING
import com.yasserakbbach.borutoapp.ui.theme.SMALL_PADDING
import com.yasserakbbach.borutoapp.ui.theme.TopAppBarContentColor

@Composable
fun HeroItem(
    hero: Hero,
    navController: NavHostController,
) {
    Box(
        modifier = Modifier
            .height(HERO_ITEM_HEIGHT)
            .clickable {
                navController.navigate(Screen.Details.passHeroId(hero.id))
            },
        contentAlignment = Alignment.BottomStart,
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = MaterialTheme.shapes.large,
        ) {
            AsyncImage(
                model = hero.imageUrl,
                contentDescription = hero.name,
                placeholder = painterResource(id = R.drawable.ic_placeholder),
                error = painterResource(id = R.drawable.ic_placeholder),
                contentScale = ContentScale.Crop,
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(.4F)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MEDIUM_PADDING),
            ) {
                Text(
                    text = hero.name,
                    color = TopAppBarContentColor,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = hero.about,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
                Row(
                    modifier = Modifier
                        .padding(SMALL_PADDING)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RatingWidget(
                        modifier = Modifier.padding(end = SMALL_PADDING) ,
                        rating = hero.rating
                    )
                    Text(
                        text = hero.formattedRating,
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium),
                    )
                }
            }
        }
    }
}