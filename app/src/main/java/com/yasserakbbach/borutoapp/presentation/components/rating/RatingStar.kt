package com.yasserakbbach.borutoapp.presentation.components.rating

sealed class RatingStar {
    data class Filled(val number: Int): RatingStar()
    data class HalfFilled(val number: Int): RatingStar()
    data class Empty(val number: Int): RatingStar()
}
