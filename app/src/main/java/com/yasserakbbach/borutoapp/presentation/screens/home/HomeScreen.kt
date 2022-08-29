package com.yasserakbbach.borutoapp.presentation.screens.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import com.yasserakbbach.borutoapp.presentation.screens.hero.ListHeroesContent

@ExperimentalPagingApi
@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val heroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar {}
        },
        content = {
            ListHeroesContent(
                heroes = heroes,
                navController = navController,
            )
        }
    )
}