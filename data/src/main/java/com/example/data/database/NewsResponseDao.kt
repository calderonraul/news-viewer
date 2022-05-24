package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.NewsResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsResponseDao {
    @Query("SELECT * FROM response_table")
    fun getAllNewsFromRoom(): Flow<NewsResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(newsResponse: NewsResponse)

    @Query("DELETE FROM response_table")
    fun clearTable()
}