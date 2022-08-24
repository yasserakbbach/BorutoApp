package com.yasserakbbach.borutoapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun setOnBoardingState(isCompleted: Boolean)
    fun getOnBoardingState(): Flow<Boolean>
}