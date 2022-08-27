package com.yasserakbbach.borutoapp.domain.usecases.hero

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.yasserakbbach.borutoapp.data.repository.HeroRepository
import com.yasserakbbach.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class GetAllHeroesUseCase(
    private val heroRepository: HeroRepository,
) {
    operator fun invoke(): Flow<PagingData<Hero>> =
        heroRepository.getAllHeroes()
}