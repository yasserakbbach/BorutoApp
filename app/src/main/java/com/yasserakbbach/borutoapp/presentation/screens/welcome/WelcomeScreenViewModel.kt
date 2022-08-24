package com.yasserakbbach.borutoapp.presentation.screens.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasserakbbach.borutoapp.domain.usecases.onboarding.OnBoardingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    private val onBoardingUseCases: OnBoardingUseCases,
): ViewModel() {

    fun setOnBoardingState(isCompleted: Boolean) {
        viewModelScope.launch {
            onBoardingUseCases.setOnBoardingStateUseCase(isCompleted)
        }
    }
}