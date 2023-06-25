package com.pidzama.firstframe.repository

import com.pidzama.firstframe.data.TitleDao
import com.pidzama.firstframe.network.model.detailItem.DetailItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataBaseRepository @Inject constructor(
    private val titleDao: TitleDao
) {

    suspend fun addTitleToFavorite(title: DetailItem) {
        titleDao.addTitleToFavorite(title)
    }

    suspend fun deleteTitleFromFavorite(title: DetailItem) {
        titleDao.deleteTitleFromFavorite(title)
    }

    fun getAllFavoriteTitles(): Flow<List<DetailItem>> {
        return titleDao.getAllFavoriteTitles()
    }
}