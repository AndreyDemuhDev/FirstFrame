package com.pidzama.firstframe.screens.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pidzama.firstframe.network.model.detailItem.DetailItem
import com.pidzama.firstframe.repository.DataBaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) : ViewModel() {

    var isTitleFavorite = MutableLiveData(false)
    val listFavoriteTitles = dataBaseRepository.getAllFavoriteTitles()

    fun addTitleToFavorite(title: DetailItem) {
        viewModelScope.launch(Dispatchers.IO) {
            title.isFavorite = true
            dataBaseRepository.addTitleToFavorite(title)
        }
    }

    fun deleteTitleFromFavorite(title: DetailItem) {
        viewModelScope.launch(Dispatchers.IO) {
            title.isFavorite = false
            dataBaseRepository.deleteTitleFromFavorite(title)
        }
    }

    fun chooseTitleFavorite(title: DetailItem) {
        if (isTitleFavorite.value == true) {
            deleteTitleFromFavorite(title)
        } else {
            addTitleToFavorite(title)
        }
        isTitleFavorite.value = !(isTitleFavorite.value ?: true)
    }
}