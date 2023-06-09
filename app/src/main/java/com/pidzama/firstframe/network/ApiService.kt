package com.pidzama.firstframe.network

import com.pidzama.firstframe.network.model.MovieItems
import com.pidzama.firstframe.utils.Constants.Companion.TOKEN
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v1.3/movie?field=typeNumber&search=1&limit=100&token=$TOKEN")
    suspend fun getAllMovie(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&search=2&limit=100&token=$TOKEN")
    suspend fun getAllTvSeries(): Response<MovieItems>
}