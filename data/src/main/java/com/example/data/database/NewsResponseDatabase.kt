package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.model.Converters
import com.example.data.model.Result
import com.example.data.model.ResultTags


@Database(entities = [Result::class,ResultTags::class], version = 6, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NewsResponseDatabase : RoomDatabase() {
    abstract val newsResponseDao: NewsResponseDao
}