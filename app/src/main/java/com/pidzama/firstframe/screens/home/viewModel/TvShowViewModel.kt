package com.pidzama.firstframe.screens.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pidzama.firstframe.network.model.Docs
import com.pidzama.firstframe.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _allTvShow = MutableLiveData<List<Docs>>()
    val allTvShow: LiveData<List<Docs>>
        get() = _allTvShow

    fun getAllTvShow() {
        viewModelScope.launch {
            movieRepository.getAllTvShow().let {
                if (it.isSuccessful) {
                    _allTvShow.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }
}