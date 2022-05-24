package com.example.domain.repository
import com.example.domain.entity.NewsResponseDomain
import kotlinx.coroutines.flow.Flow

interface NewsResponseRepository {
    suspend fun getNewsResponse()
    fun getDataFromRoom():Flow<NewsResponseDomain>
}