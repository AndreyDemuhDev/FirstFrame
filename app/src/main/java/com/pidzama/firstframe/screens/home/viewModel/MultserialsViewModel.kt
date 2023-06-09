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
class MultserialsViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _allMultserials = MutableLiveData<List<Docs>>()
    val allMultserials: LiveData<List<Docs>>
        get() = _allMultserials

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
}