package com.example.data

import com.example.data.api.NewsApi
import com.example.data.database.NewsResponseDao
import com.example.data.mappers.searchResponseMappers.ResultSearchMapper
import com.example.domain.entity.searchResponseDomain.ResultSearchDomain
import com.example.domain.repository.NewsResponseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsResponseRepositoryImpl(
    private val api: NewsApi,
    private val dao: NewsResponseDao,
    private val searchMapper: ResultSearchMapper
) : NewsResponseRepository {


    override suspend fun getTagsSearchResponse(tagParam: String) {
        val listTagsAux = api.getAllNewsByTag(tagParam)
        dao.clearTagsSearchTable()
        listTagsAux.tagsResponse?.results.let {
            if (it != null) {
                dao.insertAllTagsSearch(it)
            }
        }
    }

    override suspend fun getSectionSearchResponse(tagParam: String) {
        val listTagsAux = api.getAllNewsBySection(tagParam)
        dao.clearTagsSearchTable()
        listTagsAux.tagsResponse?.results.let {
            if (it != null) {
                dao.insertAllTagsSearch(it)
            }
        }
    }

    override fun getSearchResultsFromRoom(): Flow<List<ResultSearchDomain>> {
        return dao.getTagsSearchFromRoom().map {
            searchMapper.fromEntityList(it)
        }
    }
}