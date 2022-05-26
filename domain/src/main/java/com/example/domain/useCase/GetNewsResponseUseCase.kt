package com.example.domain.useCase

import com.example.domain.entity.NewsResponseDomain
import com.example.domain.entity.ResultDomain
import com.example.domain.repository.NewsResponseRepository
import kotlinx.coroutines.flow.Flow


class GetNewsResponseUseCase(private val repository: NewsResponseRepository) {

    operator fun invoke(section:String): Flow<List<ResultDomain>> {
        return repository.getDataFromRoom(section)
    }

    suspend fun initDB(){
        repository.getNewsResponse()
    }

}