package com.yasserakbbach.borutoapp.domain.usecases.onboarding

import com.yasserakbbach.borutoapp.data.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow

class GetOnBoardingStateUseCase(
    private val onBoardingRepository: OnBoardingRepository,
) {
    operator fun invoke(): Flow<Boolean> =
        onBoardingRepository.getOnBoardingState()
}