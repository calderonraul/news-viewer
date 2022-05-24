package com.example.data

import com.example.data.api.NewsApi
import com.example.data.database.NewsResponseDao
import com.example.data.mappers.NewsResponseMapper
import com.example.domain.entity.NewsResponseDomain
import com.example.domain.repository.NewsResponseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsResponseRepositoryImpl(
    private val api: NewsApi,
    private val mapper: NewsResponseMapper,
    private val dao: NewsResponseDao
) : NewsResponseRepository {
    override suspend fun getNewsResponse() {
        val listAux = api.getAllNews("177e6fac-ce7c-40ab-9944-f80b49099371")
        dao.clearTable()
        listAux.newsResponse?.let {
            dao.insertAll(it[0])
        }
    }

    override fun getDataFromRoom(): Flow<NewsResponseDomain> {
        return dao.getAllNewsFromRoom().map {
            mapper.mapFromEntity(it)
        }
    }
}