package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.searchResponse.ResultSearch
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsResponseDao {

    @Query("SELECT * FROM result_search_table")
    fun getTagsSearchFromRoom(): Flow<List<ResultSearch>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTagsSearch(resultTags: List<ResultSearch>)

    @Query("DELETE FROM result_search_table")
    fun clearTagsSearchTable()


}