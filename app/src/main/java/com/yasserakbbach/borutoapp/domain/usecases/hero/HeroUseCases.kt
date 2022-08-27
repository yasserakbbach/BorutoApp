package com.yasserakbbach.borutoapp.domain.usecases.hero

import androidx.paging.ExperimentalPagingApi

@ExperimentalPagingApi
data class HeroUseCases(
    val getAllHeroesUseCase: GetAllHeroesUseCase,
)
