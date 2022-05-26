package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.NewsResponse
import com.example.data.model.Result
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsResponseDao {

    @Query("SELECT * FROM results_table")
    fun getAllNewsFromRoom(): Flow<List<Result>>

    @Query("SELECT * FROM results_table WHERE id LIKE  '%' || :id || '%'")
    fun getBusinessFromRoom(id: String): Flow<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(results: List<Result>)

    @Query("DELETE FROM results_table")
    fun clearTable()
}