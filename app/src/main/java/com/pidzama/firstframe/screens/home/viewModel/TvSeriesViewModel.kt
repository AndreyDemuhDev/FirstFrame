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
class TvSeriesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _tvSeries = MutableLiveData<List<Docs>>()
    val tvSeries: LiveData<List<Docs>>
        get() = _tvSeries

    private val _topTvSeries = MutableLiveData<List<Docs>>()
    val topTvSeries: LiveData<List<Docs>>
        get() = _topTvSeries

    private val _comingSoonTvSeries = MutableLiveData<List<Docs>>()
    val comingSoonTvSeries: LiveData<List<Docs>>
        get() = _comingSoonTvSeries

    fun getListTvSeries() {
        viewModelScope.launch {
            movieRepository.getAllTvSeries().let {
                if (it.isSuccessful) {
                    _tvSeries.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getTopTvSeries() {
        viewModelScope.launch {
            movieRepository.getTopTvSeries().let {
                if (it.isSuccessful) {
                    _topTvSeries.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getComingSoonTvSeries() {
        viewModelScope.launch {
            movieRepository.getComingSoonTvSeries().let {
                if (it.isSuccessful) {
                    _comingSoonTvSeries.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }
}