package com.yasserakbbach.borutoapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yasserakbbach.borutoapp.presentation.screens.home.HomeScreen
import com.yasserakbbach.borutoapp.presentation.screens.splash.SplashScreen
import com.yasserakbbach.borutoapp.presentation.screens.welcome.WelcomeScreen

@ExperimentalPagingApi
@ExperimentalPagerApi
@ExperimentalLifecycleComposeApi
@ExperimentalMaterial3Api
@Composable
fun SetupBorutoNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(Screen.Details.HERO_ID_ARG) { type = NavType.IntType },
            )
        ) {
        }
        composable(route = Screen.Search.route) {

        }
    }
}