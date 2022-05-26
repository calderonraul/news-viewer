package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.model.Converters
import com.example.data.model.Result


@Database(entities = [Result::class], version = 3, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NewsResponseDatabase : RoomDatabase() {
    abstract val newsResponseDao: NewsResponseDao
}