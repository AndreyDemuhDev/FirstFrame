package com.pidzama.firstframe.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pidzama.firstframe.network.model.detailItem.DetailItem
import com.pidzama.firstframe.network.model.detailItem.Persons
import com.pidzama.firstframe.network.model.DetailPerson
import com.pidzama.firstframe.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _detailTitle = MutableLiveData<DetailItem>()
    val detailTitle: LiveData<DetailItem>
        get() = _detailTitle

    private val _listCast = MutableLiveData<List<Persons>>()
    val listCast: LiveData<List<Persons>>
        get() = _listCast

    private val _detailPerson = MutableLiveData<DetailPerson>()
    val detailPerson: LiveData<DetailPerson>
        get() = _detailPerson


    fun getDetailTitle(id: String) {
        viewModelScope.launch {
            movieRepository.getDetailsTitle(id).let {
                if (it.isSuccessful) {
                    _detailTitle.postValue(it.body())
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getListPersons(id: String) {
        viewModelScope.launch {
            movieRepository.getDetailsTitle(id).let {
                if (it.isSuccessful) {
                    _listCast.postValue(it.body()?.persons)
                } else {
                    it.errorBody()
                }
            }
        }
    }

    fun getDetailPerson(id: String) {
        viewModelScope.launch {
            movieRepository.getDetailPerson(id).let {
                if (it.isSuccessful) {
                    _detailPerson.postValue(it.body())
                } else {
                    it.errorBody()
                }
            }
        }
    }
}