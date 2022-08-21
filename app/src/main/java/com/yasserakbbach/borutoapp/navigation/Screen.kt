package com.yasserakbbach.borutoapp.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Welcome: Screen("welcome_screen")
    object Home: Screen("home_screen")
    object Details: Screen("details_screen/{heroId}") {
        const val HERO_ID_ARG = "heroId"
        fun passHeroId(heroId: Int): String =
            "details_screen/$heroId"
    }
    object Search: Screen("search_screen")
}
