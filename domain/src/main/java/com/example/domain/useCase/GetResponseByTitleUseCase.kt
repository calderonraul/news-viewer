package com.example.domain.useCase

import com.example.domain.entity.searchResponseDomain.ResultSearchDomain
import com.example.domain.repository.NewsResponseRepository
import kotlinx.coroutines.flow.Flow

class GetResponseByTitleUseCase(private val repository: NewsResponseRepository) {
    operator fun invoke(search:String):Flow<List<ResultSearchDomain>>{
        return repository.getSearchResultByTitle(search)
    }
}