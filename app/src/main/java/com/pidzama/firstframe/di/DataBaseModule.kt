package com.pidzama.firstframe.di

import android.content.Context
import androidx.room.Room
import com.pidzama.firstframe.data.DataBase
import com.pidzama.firstframe.data.TitleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    fun provideDB(@ApplicationContext context: Context) : DataBase {
        return Room.databaseBuilder(
            context,
            DataBase::class.java,
            "database-name"
        ).build()
    }

    @Provides
    fun provideMovieDao(appDataBase: DataBase): TitleDao {
        return appDataBase.movieDao()
    }

}