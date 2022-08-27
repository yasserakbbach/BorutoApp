package com.yasserakbbach.borutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.yasserakbbach.borutoapp.domain.model.Hero
import com.yasserakbbach.borutoapp.domain.repository.HeroRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class HeroRepository @Inject constructor(
    private val heroRemoteDataSource: HeroRemoteDataSource,
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> = heroRemoteDataSource.getAllHeroes()
}