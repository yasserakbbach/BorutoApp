package com.yasserakbbach.borutoapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.yasserakbbach.borutoapp.domain.model.Hero
import com.yasserakbbach.borutoapp.domain.usecases.hero.HeroUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val heroUseCases: HeroUseCases,
): ViewModel() {

    val getAllHeroes: Flow<PagingData<Hero>> = heroUseCases.getAllHeroesUseCase()
}