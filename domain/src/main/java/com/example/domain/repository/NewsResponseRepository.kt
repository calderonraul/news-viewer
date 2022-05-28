package com.example.domain.repository
import com.example.domain.entity.ResultDomain
import com.example.domain.entity.ResultTagsDomain
import kotlinx.coroutines.flow.Flow

interface NewsResponseRepository {
    suspend fun getNewsResponse()
    fun getDataFromRoom(section:String):Flow<List<ResultDomain>>
    fun getTagsFromRoom():Flow<List<ResultTagsDomain>>
    suspend fun getTagsResponse()

    //Lo que sirve
    suspend fun getTagsSearchResponse(tagParam:String)


}