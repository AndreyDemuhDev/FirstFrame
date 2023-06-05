package com.pidzama.firstframe.screens.onBoarding

import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pidzama.firstframe.data.DataStoreRepository
import com.pidzama.firstframe.navigation.Graph

class SplashScreenViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Graph.ONBOARDING)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Graph.AUTHENTICATION
                } else {
                    _startDestination.value = Graph.ONBOARDING
                }
            }
            _isLoading.value = false
        }
    }

}