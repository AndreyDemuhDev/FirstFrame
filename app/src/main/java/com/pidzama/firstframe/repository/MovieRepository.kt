package com.pidzama.firstframe.repository

import com.pidzama.firstframe.network.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllMovies() = apiService.getAllMovie()

    suspend fun getAllTvSeries() = apiService.getAllTvSeries()
}