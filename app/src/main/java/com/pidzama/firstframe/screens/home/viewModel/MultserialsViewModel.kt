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
class MultserialsViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _allMultserials = MutableLiveData<List<Docs>>()
    val allMultserials: LiveData<List<Docs>>
        get() = _allMultserials

    private val _topMultserials = MutableLiveData<List<Docs>>()
    val topMultserials: LiveData<List<Docs>>
        get() = _topMultserials

    private val _comingSoonMultserials = MutableLiveData<List<Docs>>()
    val comingSoonMultserials: LiveData<List<Docs>>
        get() = _comingSoonMultserials

    fun getAllMultserials() {
        viewModelScope.launch {
            movieRepository.getAllMultserials().let {
                if (it.isSuccessful) {
                    _allMultserials.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getTopMultserials() {
        viewModelScope.launch {
            movieRepository.getTopMultderials().let {
                if (it.isSuccessful) {
                    _topMultserials.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getComingSoonMultserials() {
        viewModelScope.launch {
            movieRepository.getComingSoonMultserials().let {
                if (it.isSuccessful) {
                    _comingSoonMultserials.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }
}