package com.pidzama.firstframe.data

import androidx.room.*
import com.pidzama.firstframe.network.model.detailItem.DetailItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TitleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTitleToFavorite(title: DetailItem)

    @Delete
    suspend fun deleteTitleFromFavorite(title: DetailItem)

    @Query("SELECT * FROM title_table")
    fun getAllFavoriteTitles(): Flow<List<DetailItem>>
}