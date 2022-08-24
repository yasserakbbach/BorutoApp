package com.yasserakbbach.borutoapp.di

import android.content.Context
import com.yasserakbbach.borutoapp.data.repository.DataStoreOperationsImpl
import com.yasserakbbach.borutoapp.domain.repository.DataStoreOperations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context,
    ): DataStoreOperations =
        DataStoreOperationsImpl(context)
}