package com.example.domain.repository
import com.example.domain.entity.ResultDomain
import kotlinx.coroutines.flow.Flow

interface NewsResponseRepository {
    suspend fun getNewsResponse()
    fun getDataFromRoom(section:String):Flow<List<ResultDomain>>
}