package com.yasserakbbach.borutoapp.presentation.screens.home

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.yasserakbbach.borutoapp.R
import com.yasserakbbach.borutoapp.ui.theme.TopAppBarBackgroundColor
import com.yasserakbbach.borutoapp.ui.theme.TopAppBarContentColor

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.second_on_boarding_page_greetings),
                color = TopAppBarContentColor,
            )
        },
        backgroundColor = TopAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.home_screen_search),
                    tint = TopAppBarContentColor,
                )
            }
        },
        modifier = modifier,
    )
}