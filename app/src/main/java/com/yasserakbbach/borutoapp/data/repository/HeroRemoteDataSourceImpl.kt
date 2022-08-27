package com.yasserakbbach.borutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.yasserakbbach.borutoapp.data.local.BorutoDatabase
import com.yasserakbbach.borutoapp.data.local.dao.HeroDao
import com.yasserakbbach.borutoapp.data.pagingsource.HeroRemoteMediator
import com.yasserakbbach.borutoapp.data.remote.BorutoApi
import com.yasserakbbach.borutoapp.domain.model.Hero
import com.yasserakbbach.borutoapp.domain.repository.HeroRemoteDataSource
import com.yasserakbbach.borutoapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class HeroRemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase,
) : HeroRemoteDataSource {

    private val heroDao: HeroDao by lazy {
        borutoDatabase.heroDao()
    }

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase,
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }

    override fun searchHeroesBy(name: String): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}