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
class AnimeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _allAnime = MutableLiveData<List<Docs>>()
    val allAnime: LiveData<List<Docs>>
        get() = _allAnime

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
}