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
class CartoonViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _allCartoons = MutableLiveData<List<Docs>>()
    val allCartoons: LiveData<List<Docs>>
        get() = _allCartoons

    private val _topCartoons = MutableLiveData<List<Docs>>()
    val topCartoons: LiveData<List<Docs>>
        get() = _topCartoons

    private val _comingSoonCartoons = MutableLiveData<List<Docs>>()
    val comingSoonCartoons: LiveData<List<Docs>>
        get() = _comingSoonCartoons

    fun getAllCatroons() {
        viewModelScope.launch {
            movieRepository.getAllCartoon().let {
                if (it.isSuccessful) {
                    _allCartoons.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getTopCartoons() {
        viewModelScope.launch {
            movieRepository.getTopCartoon().let {
                if (it.isSuccessful) {
                    _topCartoons.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getComingSoonCartoon(){
        viewModelScope.launch {
            movieRepository.getComingSoonCartoon().let{
                if (it.isSuccessful){
                    _comingSoonCartoons.postValue(it.body()?.docs)
                } else {
                    it.errorBody()
                }
            }
        }
    }
}