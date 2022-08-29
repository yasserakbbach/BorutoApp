package com.yasserakbbach.borutoapp.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import com.yasserakbbach.borutoapp.presentation.components.rating.RatingWidget

@ExperimentalPagingApi
@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val heroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar {}
        }
    ) { padding ->
        RatingWidget(
            modifier = Modifier.padding(padding),
            rating = .5
        )
    }
}

@ExperimentalPagingApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}