package com.yasserakbbach.borutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupBorutoNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {

        }
        composable(route = Screen.Welcome.route) {

        }
        composable(route = Screen.Home.route) {

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