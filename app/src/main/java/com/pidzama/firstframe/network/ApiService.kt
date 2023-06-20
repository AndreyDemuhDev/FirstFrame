package com.pidzama.firstframe.network

import com.pidzama.firstframe.network.model.detailItem.DetailItem
import com.pidzama.firstframe.network.model.detailPerson.DetailPerson
import com.pidzama.firstframe.network.model.search.SearchItem
import com.pidzama.firstframe.network.model.titles.Docs
import com.pidzama.firstframe.network.model.titles.MovieItems
import com.pidzama.firstframe.utils.Constants.Companion.TOKEN
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    //фильмы
    @GET("v1.3/movie?field=typeNumber&search=1&limit=100&token=$TOKEN") //все фильмы
    suspend fun getAllMovie(): Response<MovieItems>

    @GET("v1.3/movie/{id}?token=$TOKEN")
    suspend fun getDetailTitle(@Path("id") id: String):  Response<DetailItem>

    @GET("v1/person/{id}?token=$TOKEN")
    suspend fun getDetailPerson(@Path("id") id: String):  Response<DetailPerson>

    @GET("/v1.2/movie/search?page=1&limit=10&token=$TOKEN")
    suspend fun searchTitle(@Query("query") query: String): SearchItem

    @GET("v1.3/movie?field=typeNumber&rating.imdb=8-10&search=1&limit=100&token=$TOKEN") //топы фильма
    suspend fun getTopAllMovie(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&year=2023-2030&search=1&limit=100&token=$TOKEN") //новые фильмы
    suspend fun getComingSoonMovie(): Response<MovieItems>

    //сериалы
    @GET("v1.3/movie?field=typeNumber&search=2&limit=100&token=$TOKEN") //сериалы
    suspend fun getAllTvSeries(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&rating.imdb=8-10&search=2&limit=100&token=$TOKEN") //топы сериалы
    suspend fun getTopTvSeries(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&year=2023-2030&search=2&limit=100&token=$TOKEN") //новые сериалы
    suspend fun getComingSoonTvSeries(): Response<MovieItems>

    //мультфильмы
    @GET("v1.3/movie?field=typeNumber&search=3&limit=100&token=$TOKEN") //мультфильмы
    suspend fun getAllCartoon(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&rating.imdb=8-10&search=3&limit=100&token=$TOKEN") //топы мультфильмов
    suspend fun getTopCartoon(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&year=2023-2030&search=3&limit=100&token=$TOKEN") //новые мультфильмов
    suspend fun getComingSoonCartoon(): Response<MovieItems>

    //аниме
    @GET("v1.3/movie?field=typeNumber&search=4&limit=100&token=$TOKEN") //аниме
    suspend fun getAllAnime(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&rating.imdb=6-10&search=4&limit=100&token=$TOKEN") //топы аниме
    suspend fun getTopAnime(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&year=2023-2030&search=4&limit=100&token=$TOKEN") //новые аниме
    suspend fun getComingSoonAnime(): Response<MovieItems>

    //мультсериалы
    @GET("v1.3/movie?field=typeNumber&search=5&limit=100&token=$TOKEN")  //мультсериалы
    suspend fun getAllMultserials(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&rating.imdb=8-10&search=5&limit=100&token=$TOKEN") //топы мультсериалы
    suspend fun getTopMultserials(): Response<MovieItems>

    @GET("v1.3/movie?field=typeNumber&year=2023-2030&search=5&limit=100&token=$TOKEN") //новые мультсериалы
    suspend fun getComingSoonMultserials(): Response<MovieItems>
}