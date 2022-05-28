package com.example.data

import android.util.Log
import com.example.data.api.NewsApi
import com.example.data.database.NewsResponseDao
import com.example.data.mappers.newsResponseMappers.ResultMapper
import com.example.data.mappers.tagsResponseMappers.ResultTagsMapper
import com.example.domain.entity.ResultDomain
import com.example.domain.entity.ResultTagsDomain
import com.example.domain.repository.NewsResponseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsResponseRepositoryImpl(
    private val api: NewsApi,
    private val mapper: ResultMapper,
    private val dao: NewsResponseDao,
    private val tagsMapper: ResultTagsMapper
) : NewsResponseRepository {
    override suspend fun getNewsResponse() {
        val listAux = api.getAllNews()
        dao.clearTable()
        listAux.newsResponse?.let {
            dao.insertAll(it.results)
        }
    }

    override fun getDataFromRoom(section: String): Flow<List<ResultDomain>> {
        if (section.isBlank()) {
            return dao.getAllNewsFromRoom().map {
                mapper.fromEntityList(it)
            }
        } else {
            return dao.getBusinessFromRoom(section).map {
                mapper.fromEntityList(it)
            }
        }
    }

    override fun getTagsFromRoom(): Flow<List<ResultTagsDomain>> {

        return dao.getAllTagsFromRoom().map {
            tagsMapper.fromEntityList(it)
        }
    }

    override suspend fun getTagsResponse() {
        val listTagsAux = api.getAllTags()

        dao.clearTagsTable()
        listTagsAux.tagsResponse.let {
            if (it != null) {
                dao.insertAllTags(it.results)
            }
        }
    }

    override suspend fun getTagsSearchResponse(tagParam:String) {
        val listTagsAux = api.getAllNewsByTag(tagParam)
        dao.clearTagsSearchTable()
        listTagsAux.tagsResponse?.results.let {
            if (it != null) {
                dao.insertAllTagsSearch(it)
            }
        }
    }
}