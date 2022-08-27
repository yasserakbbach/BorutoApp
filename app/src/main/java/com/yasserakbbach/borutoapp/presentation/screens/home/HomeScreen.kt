package com.yasserakbbach.borutoapp.presentation.screens.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems

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
    ) {

    }
}

@ExperimentalPagingApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}