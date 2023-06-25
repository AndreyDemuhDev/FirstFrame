package com.pidzama.firstframe.screens.home.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pidzama.firstframe.repository.MovieRepository
import com.pidzama.firstframe.utils.MainState
import com.pidzama.firstframe.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val searchList: MutableState<MainState> = mutableStateOf(MainState())

    fun searchTitle(query: String) = viewModelScope.launch {
        searchList.value = MainState(isLoading = true)
        try {
            val result = movieRepository.searchTitle(query)
            when (result) {
                is Resource.Error -> {
                    searchList.value = MainState(error = "Something went wrong")
                }
                is Resource.Success -> {
                    result.data?.docs?.let {
                        searchList.value = MainState(data = it)
                    }
                }
                else -> {}
            }
        } catch (e: Exception) {
            searchList.value = MainState(error = "Something went wrong")
        }
    }
}