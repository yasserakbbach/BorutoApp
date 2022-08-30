package com.yasserakbbach.borutoapp.presentation.screens.hero

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.yasserakbbach.borutoapp.domain.model.Hero
import com.yasserakbbach.borutoapp.presentation.components.hero.HeroShimmerEffect
import com.yasserakbbach.borutoapp.ui.theme.SMALL_PADDING

@Composable
fun ListHeroesContent(
    modifier: Modifier,
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController,
) {
    val results = handlePagingResult(heroes = heroes)

    if(results) {
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
}

@Composable
fun handlePagingResult(
    heroes: LazyPagingItems<Hero>,
): Boolean {
    heroes.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                HeroShimmerEffect()
                false
            }
            error != null -> false
            else -> true
        }
    }
}