package com.yasserakbbach.borutoapp.domain.repository

import androidx.paging.PagingData
import com.yasserakbbach.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface HeroRemoteDataSource {

    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroesBy(name: String): Flow<PagingData<Hero>>
}