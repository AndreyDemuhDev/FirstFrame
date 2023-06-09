package com.pidzama.firstframe.di

import com.pidzama.firstframe.network.ApiService
import com.pidzama.firstframe.repository.MovieRepository
import com.pidzama.firstframe.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesMovieRepository(apiService: ApiService): MovieRepository {
        return MovieRepository(apiService = apiService)
    }
}