package com.pidzama.firstframe.repository

import com.pidzama.firstframe.network.ApiService
import com.pidzama.firstframe.network.model.search.SearchItem
import com.pidzama.firstframe.network.model.titles.MovieItems
import com.pidzama.firstframe.utils.Resource
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    //фильмы
    suspend fun getAllMovies() = apiService.getAllMovie()
    suspend fun getTopMovies() = apiService.getTopAllMovie()
    suspend fun getComingSoonMovies() = apiService.getComingSoonMovie()

    //сериалы
    suspend fun getAllTvSeries() = apiService.getAllTvSeries()
    suspend fun getTopTvSeries() = apiService.getTopTvSeries()
    suspend fun getComingSoonTvSeries() = apiService.getComingSoonTvSeries()

    //аниме
    suspend fun getAllAnime() = apiService.getAllAnime()
    suspend fun getTopAnime() = apiService.getTopAnime()
    suspend fun getComingSoonAnime() = apiService.getComingSoonAnime()

    //мультфильмы
    suspend fun getAllCartoon() = apiService.getAllCartoon()
    suspend fun getTopCartoon() = apiService.getTopCartoon()
    suspend fun getComingSoonCartoon() = apiService.getComingSoonCartoon()

    //мультсериалы
    suspend fun getAllMultserials() = apiService.getAllMultserials()
    suspend fun getTopMultderials() = apiService.getTopMultserials()
    suspend fun getComingSoonMultserials() = apiService.getComingSoonMultserials()

    //детали
    suspend fun getDetailsTitle(id: String) = apiService.getDetailTitle(id)
    suspend fun getDetailPerson(id: String) = apiService.getDetailPerson(id)

    //поиск тайтлов
    suspend fun searchTitle(query: String): Resource<SearchItem> {
        return try {
            val result = apiService.searchTitle(query)
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}