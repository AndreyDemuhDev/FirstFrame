package com.pidzama.firstframe.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.pidzama.firstframe.utils.Constants.DataStorePreference.FAVORITE
import com.pidzama.firstframe.utils.Constants.DataStorePreference.ONBOARDING_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "data_store_pref")

class DataStoreRepository(val context: Context) {

    private val dataStore = context.dataStore

    suspend fun saveOnBoardingState(completed: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(ONBOARDING_KEY)] = completed
        }
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[booleanPreferencesKey(ONBOARDING_KEY)] ?: false
                onBoardingState
            }
    }

    suspend fun setFavoriteTitle(isFavorite: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(FAVORITE)] = isFavorite
        }
    }

    fun getFavoriteTitle() = dataStore.data.map { preferences ->
        val isFavoriteTitle = preferences[intPreferencesKey(FAVORITE)] ?: false
        isFavoriteTitle
    }
}