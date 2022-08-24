package com.yasserakbbach.borutoapp.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.yasserakbbach.borutoapp.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okio.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "boruto_preferences")

class DataStoreOperationsImpl(
    context: Context,
) : DataStoreOperations {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = ON_BOARDING_KEY)
    }
    private val dataStore = context.dataStore

    override suspend fun setOnBoardingState(isCompleted: Boolean) {
        dataStore.edit {
            it[PreferencesKey.onBoardingKey] = isCompleted
        }
    }

    override fun getOnBoardingState(): Flow<Boolean> =
        dataStore.data
            .catch { exception->
                if(exception is IOException) emit(emptyPreferences())
                else throw exception
            }.map {
                it[PreferencesKey.onBoardingKey] ?: false
            }

    private companion object {
        const val ON_BOARDING_KEY = "ON_BOARDING_KEY"
    }
}