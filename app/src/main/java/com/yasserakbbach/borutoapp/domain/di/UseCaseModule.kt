package com.yasserakbbach.borutoapp.domain.di

import androidx.paging.ExperimentalPagingApi
import com.yasserakbbach.borutoapp.data.repository.HeroRepository
import com.yasserakbbach.borutoapp.data.repository.OnBoardingRepository
import com.yasserakbbach.borutoapp.domain.usecases.hero.GetAllHeroesUseCase
import com.yasserakbbach.borutoapp.domain.usecases.hero.HeroUseCases
import com.yasserakbbach.borutoapp.domain.usecases.onboarding.GetOnBoardingStateUseCase
import com.yasserakbbach.borutoapp.domain.usecases.onboarding.OnBoardingUseCases
import com.yasserakbbach.borutoapp.domain.usecases.onboarding.SetOnBoardingStateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@ExperimentalPagingApi
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideOnBoardingUseCases(
        onBoardingRepository: OnBoardingRepository,
    ): OnBoardingUseCases =
        OnBoardingUseCases(
            SetOnBoardingStateUseCase(onBoardingRepository),
            GetOnBoardingStateUseCase(onBoardingRepository),
        )

    @Provides
    @Singleton
    fun provideHeroUseCases(
        heroRepository: HeroRepository,
    ): HeroUseCases =
        HeroUseCases(
            getAllHeroesUseCase = GetAllHeroesUseCase(heroRepository)
        )
}