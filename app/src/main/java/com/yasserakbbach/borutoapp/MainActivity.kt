package com.yasserakbbach.borutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yasserakbbach.borutoapp.navigation.SetupBorutoNavGraph
import com.yasserakbbach.borutoapp.ui.theme.BorutoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagingApi
@ExperimentalMaterial3Api
@ExperimentalPagerApi
@ExperimentalLifecycleComposeApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoAppTheme {
                val navController = rememberNavController()
                SetupBorutoNavGraph(navController = navController)
            }
        }
    }
}