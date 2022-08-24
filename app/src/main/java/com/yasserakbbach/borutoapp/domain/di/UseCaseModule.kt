package com.yasserakbbach.borutoapp.domain.di

import com.yasserakbbach.borutoapp.data.repository.OnBoardingRepository
import com.yasserakbbach.borutoapp.domain.usecases.onboarding.GetOnBoardingStateUseCase
import com.yasserakbbach.borutoapp.domain.usecases.onboarding.OnBoardingUseCases
import com.yasserakbbach.borutoapp.domain.usecases.onboarding.SetOnBoardingStateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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
}