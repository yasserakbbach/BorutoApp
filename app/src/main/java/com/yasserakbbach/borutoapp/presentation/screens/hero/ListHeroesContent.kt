package com.yasserakbbach.borutoapp.presentation.screens.hero

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import com.yasserakbbach.borutoapp.domain.model.Hero
import com.yasserakbbach.borutoapp.util.HeroSample

@Composable
fun ListHeroesContent(
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController,
) {

}

@Preview
@Composable
fun HeroItemPreview() {
    HeroItem(
        hero = HeroSample.heroPage1().random(),
        navController = rememberNavController()
    )
}