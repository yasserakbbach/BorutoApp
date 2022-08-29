package com.yasserakbbach.borutoapp.presentation.screens.hero

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.yasserakbbach.borutoapp.domain.model.Hero
import com.yasserakbbach.borutoapp.ui.theme.SMALL_PADDING
import com.yasserakbbach.borutoapp.util.HeroSample

@Composable
fun ListHeroesContent(
    modifier: Modifier,
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING),
    ) {
        items(
            items = heroes,
            key = { hero -> hero.id },
        ) { hero ->
            hero?.let {
                HeroItem(
                    hero = it,
                    navController = navController,
                )
            }

        }
    }
}

@Preview
@Composable
fun HeroItemPreview() {
    HeroItem(
        hero = HeroSample.heroPage1().random(),
        navController = rememberNavController()
    )
}