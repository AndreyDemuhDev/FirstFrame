package com.pidzama.firstframe.screens.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pidzama.firstframe.network.model.titles.Docs
import com.pidzama.firstframe.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _allAnime = MutableLiveData<List<Docs>>()
    val allAnime: LiveData<List<Docs>>
        get() = _allAnime

    private val _topAnime = MutableLiveData<List<Docs>>()
    val topAnime: LiveData<List<Docs>>
        get() = _topAnime

    private val _comingSoonAnime = MutableLiveData<List<Docs>>()
    val comingSoonAnime: LiveData<List<Docs>>
        get() = _comingSoonAnime

    fun getAllAnime() {
        viewModelScope.launch {
            movieRepository.getAllAnime().let {
                if (it.isSuccessful) {
                    _allAnime.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getTopAnime() {
        viewModelScope.launch {
            movieRepository.getTopAnime().let {
                if (it.isSuccessful) {
                    _topAnime.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getComingSoonAnime() {
        viewModelScope.launch {
            movieRepository.getComingSoonAnime().let {
                if (it.isSuccessful) {
                    _comingSoonAnime.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }
}