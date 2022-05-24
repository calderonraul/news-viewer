package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.data.model.Converters
import com.example.data.model.NewsResponse


@Database(entities = [NewsResponse::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NewsResponseDatabase : RoomDatabase() {
    abstract val newsResponseDao: NewsResponseDao
}