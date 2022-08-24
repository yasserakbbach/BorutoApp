package com.yasserakbbach.borutoapp.domain.usecases.onboarding

import com.yasserakbbach.borutoapp.data.repository.OnBoardingRepository
import javax.inject.Inject

class SetOnBoardingStateUseCase(
    private val onBoardingRepository: OnBoardingRepository,
) {
    suspend operator fun invoke(isCompleted: Boolean) {
        onBoardingRepository.setOnBoardingState(isCompleted)
    }
}