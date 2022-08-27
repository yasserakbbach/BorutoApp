package com.yasserakbbach.borutoapp.data.remote

import com.yasserakbbach.borutoapp.domain.model.HeroApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {

    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1,
    ): HeroApiResponse

    @GET("/boruto/heroes/search")
    suspend fun searchHeroesByName(
        @Query("name") name: String,
    ): HeroApiResponse
}