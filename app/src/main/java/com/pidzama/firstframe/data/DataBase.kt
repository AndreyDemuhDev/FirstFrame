package com.pidzama.firstframe.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pidzama.firstframe.network.model.detailItem.DetailItem
import com.pidzama.firstframe.utils.GenresConverter
import com.pidzama.firstframe.utils.PersonsConverter
import com.pidzama.firstframe.utils.RatingConverter
import com.pidzama.firstframe.utils.VideosConverter

@Database(entities = [DetailItem::class], version = 1)
@TypeConverters(
    RatingConverter::class,
    VideosConverter::class,
    GenresConverter::class,
    PersonsConverter::class
)
abstract class DataBase : RoomDatabase() {

    abstract fun movieDao(): TitleDao
}