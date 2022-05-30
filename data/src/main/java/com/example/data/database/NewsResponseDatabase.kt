package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.model.Converters
import com.example.data.model.searchResponse.ResultSearch


@Database(entities = [ResultSearch::class], version = 10, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NewsResponseDatabase : RoomDatabase() {
    abstract val newsResponseDao: NewsResponseDao
}