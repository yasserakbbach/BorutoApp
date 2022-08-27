package com.yasserakbbach.borutoapp.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.yasserakbbach.borutoapp.data.local.BorutoDatabase
import com.yasserakbbach.borutoapp.data.remote.BorutoApi
import com.yasserakbbach.borutoapp.domain.model.Hero
import com.yasserakbbach.borutoapp.domain.model.HeroApiResponse
import com.yasserakbbach.borutoapp.domain.model.HeroRemoteKeys
import java.lang.Exception
import javax.inject.Inject

@ExperimentalPagingApi
class HeroRemoteMediator @Inject constructor(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase,
) : RemoteMediator<Int, Hero>() {

    private val heroDao = borutoDatabase.heroDao()
    private val heroRemoteKeysDao = borutoDatabase.heroRemoteKeysDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        return try {
            val page = when(loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = state.getRemoteKeyClosestToCurrentPosition()
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeysForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeysForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys?.nextPage != null)
                    nextPage
                }
            }

            val response = borutoApi.getAllHeroes(page = page)
            val heroes = response.heroes
            if(heroes.isNotEmpty()) {
                borutoDatabase.withTransaction {

                    if(loadType == LoadType.REFRESH) purgeHeroAndRemoteKeysFromLocalDatabase()

                    response.storeHeroAndRemoteKeys()
                }
            }

            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun purgeHeroAndRemoteKeysFromLocalDatabase() {
        heroDao.deleteAllHeroes()
        heroRemoteKeysDao.deleteAllHeroRemoteKeys()
    }

    private suspend fun HeroApiResponse.storeHeroAndRemoteKeys() {
        val heroRemoteKeys = heroes.map { hero ->
            HeroRemoteKeys(
                id = hero.id,
                prevPage = prevPage,
                nextPage = nextPage,
            )
        }

        heroRemoteKeysDao.insertHeroRemoteKeys(heroRemoteKeys)
        heroDao.insertHeroes(heroes)
    }

    private suspend fun PagingState<Int, Hero>.getRemoteKeyClosestToCurrentPosition(): HeroRemoteKeys? =
        anchorPosition?.run {
            closestItemToPosition(this)
        }?.run {
            heroRemoteKeysDao.getHeroRemoteKeysBy(id)
        }

    private suspend fun getRemoteKeysForFirstItem(
        state: PagingState<Int, Hero>,
    ): HeroRemoteKeys? =
        state.pages.firstOrNull { it.data.isNotEmpty()}?.data?.firstOrNull()
            ?.let { hero ->
                heroRemoteKeysDao.getHeroRemoteKeysBy(hero.id)
            }

    private suspend fun getRemoteKeysForLastItem(
        state: PagingState<Int, Hero>,
    ): HeroRemoteKeys? =
        state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { hero ->
                heroRemoteKeysDao.getHeroRemoteKeysBy(heroId = hero.id)
            }
}