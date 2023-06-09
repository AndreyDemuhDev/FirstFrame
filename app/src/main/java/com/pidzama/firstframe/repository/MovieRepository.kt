package com.pidzama.firstframe.repository

import com.pidzama.firstframe.network.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllMovies() = apiService.getAllMovie()
    suspend fun getTopMovies() = apiService.getTopAllMovie()
    suspend fun getAllTvSeries() = apiService.getAllTvSeries()
    suspend fun getAllAnime() = apiService.getAllAnime()
    suspend fun getAllCartoon() = apiService.getAllCartoon()
    suspend fun getAllMultserials() = apiService.getAllMultserials()
    suspend fun getAllTvShow() = apiService.getAllTvShow()
}