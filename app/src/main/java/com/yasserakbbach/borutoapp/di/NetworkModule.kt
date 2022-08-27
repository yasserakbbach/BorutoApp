package com.yasserakbbach.borutoapp.di

import androidx.paging.ExperimentalPagingApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.yasserakbbach.borutoapp.data.local.BorutoDatabase
import com.yasserakbbach.borutoapp.data.remote.BorutoApi
import com.yasserakbbach.borutoapp.data.repository.HeroRemoteDataSourceImpl
import com.yasserakbbach.borutoapp.domain.repository.HeroRemoteDataSource
import com.yasserakbbach.borutoapp.util.Constants.BORUTO_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BORUTO_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()

    @Provides
    @Singleton
    fun provideBorutoApi(
        retrofit: Retrofit,
    ): BorutoApi =
        retrofit.create()

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        borutoApi: BorutoApi,
        borutoDatabase: BorutoDatabase,
    ): HeroRemoteDataSource =
        HeroRemoteDataSourceImpl(
            borutoApi,
            borutoDatabase,
        )
}