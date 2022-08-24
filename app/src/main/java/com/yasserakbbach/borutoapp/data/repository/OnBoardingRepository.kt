package com.yasserakbbach.borutoapp.data.repository

import com.yasserakbbach.borutoapp.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OnBoardingRepository @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
){

    suspend fun setOnBoardingState(isCompleted: Boolean) {
        dataStoreOperations.setOnBoardingState(isCompleted)
    }
    fun getOnBoardingState(): Flow<Boolean> =
        dataStoreOperations.getOnBoardingState()
}