package com.yasserakbbach.borutoapp.presentation.screens.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalMaterial3Api
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeTopBar {}
        }
    ) {

    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}