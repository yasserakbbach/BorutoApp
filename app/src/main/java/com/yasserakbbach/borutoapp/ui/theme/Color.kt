package com.yasserakbbach.borutoapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Black = Color(0XFF000000)
val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)

val WelcomeScreenBackgroundColor
    @Composable
    get() = if(isSystemInDarkTheme()) Color.Black else Color.White

val WelcomeScreenTitleColor
    @Composable
    get() = if(isSystemInDarkTheme()) LightGray else DarkGray

val WelcomeScreenDescriptionColor
    @Composable
    get() = if(isSystemInDarkTheme()) LightGray.copy(alpha = .5F) else DarkGray.copy(alpha = .5F)

val WelcomeScreenActiveIndicatorColor
    @Composable
    get() = if(isSystemInDarkTheme()) Purple700 else Purple500

val WelcomeScreenInActiveIndicatorColor
    @Composable
    get() = if(isSystemInDarkTheme()) DarkGray else LightGray

val WelcomeScreenFinishButtonColor
    @Composable
    get() = if(isSystemInDarkTheme()) Purple700 else Purple500

val TopAppBarContentColor
    @Composable
    get() = if(isSystemInDarkTheme()) LightGray else Color.White

val TopAppBarBackgroundColor
    @Composable
    get() = if(isSystemInDarkTheme()) Color.Black else Purple500