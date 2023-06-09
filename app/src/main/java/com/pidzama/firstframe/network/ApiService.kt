package com.pidzama.firstframe.network

import com.pidzama.firstframe.network.model.MovieItems
import com.pidzama.firstframe.utils.Constants.Companion.TOKEN
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v1.3/movie?field=typeNumber&search=1&limit=100&token=$TOKEN") //фильмы
    suspend fun getAllMovie(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&year=2023&search=1&limit=100&token=$TOKEN") //фильмы
    suspend fun getTopAllMovie(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&search=2&limit=100&token=$TOKEN") //сериалы
    suspend fun getAllTvSeries(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&search=3&limit=100&token=$TOKEN") //мультфильмы
    suspend fun getAllCartoon(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&search=4&limit=100&token=$TOKEN") //аниме
    suspend fun getAllAnime(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&search=5&limit=100&token=$TOKEN")  //мультсериалы
    suspend fun getAllMultserials(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&search=6&limit=100&token=$TOKEN")  //ТВ шоу
    suspend fun getAllTvShow(): Response<MovieItems>
}