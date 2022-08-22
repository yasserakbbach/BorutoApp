package com.yasserakbbach.borutoapp.presentation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.yasserakbbach.borutoapp.R

sealed class OnBoardingPage(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
) {
    object First: OnBoardingPage(
        image = R.drawable.greetings,
        title = R.string.first_on_boarding_page_greetings,
        description =R.string.first_on_boarding_page_description,
    )
    object Second: OnBoardingPage(
        image = R.drawable.explore,
        title = R.string.second_on_boarding_page_greetings,
        description =R.string.second_on_boarding_page_description,
    )
    object Third: OnBoardingPage(
        image = R.drawable.power,
        title = R.string.third_on_boarding_page_greetings,
        description =R.string.third_on_boarding_page_description,
    )
}
