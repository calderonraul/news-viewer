package com.example.domain.repository
import com.example.domain.entity.searchResponseDomain.ResultSearchDomain
import kotlinx.coroutines.flow.Flow

interface NewsResponseRepository {
    suspend fun getTagsSearchResponse(tagParam:String)
    suspend fun getSectionSearchResponse(tagParam:String)
    fun getSearchResultsFromRoom():Flow<List<ResultSearchDomain>>


}