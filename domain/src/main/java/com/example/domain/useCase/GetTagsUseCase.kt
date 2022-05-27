package com.example.domain.useCase

import com.example.domain.entity.ResultTagsDomain
import com.example.domain.repository.NewsResponseRepository
import kotlinx.coroutines.flow.Flow

class GetTagsUseCase(private val repository: NewsResponseRepository) {
    operator fun invoke():Flow<List<ResultTagsDomain>>{
       return repository.getTagsFromRoom()
    }

     suspend fun initDbTags(){
        repository.getTagsResponse()
    }
}