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
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _allMovies = MutableLiveData<List<Docs>>()
    val allMovies: LiveData<List<Docs>>
        get() = _allMovies

    fun getAllMovies() {
        viewModelScope.launch {
            movieRepository.getAllMovies().let {
                if (it.isSuccessful) {
                    _allMovies.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }
}