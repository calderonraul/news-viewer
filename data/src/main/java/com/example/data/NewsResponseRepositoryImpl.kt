package com.example.data

import android.util.Log
import com.example.data.api.NewsApi
import com.example.data.database.NewsResponseDao
import com.example.data.mappers.NewsResponseMapper
import com.example.data.mappers.ResultMapper
import com.example.domain.entity.NewsResponseDomain
import com.example.domain.entity.ResultDomain
import com.example.domain.repository.NewsResponseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsResponseRepositoryImpl(
    private val api: NewsApi,
    private val mapper: ResultMapper,
    private val dao: NewsResponseDao
) : NewsResponseRepository {
    override suspend fun getNewsResponse() {
        val listAux = api.getAllNews()
        dao.clearTable()
        listAux.newsResponse?.let {
          dao.insertAll(it.results)
        }

    }

    override fun getDataFromRoom(): Flow<List<ResultDomain>> {
        return dao.getAllNewsFromRoom().map {
            mapper.fromEntityList(it)
        }
    }
}