package com.example.domain.useCase

import com.example.domain.entity.searchResponseDomain.ResultSearchDomain
import com.example.domain.repository.NewsResponseRepository
import kotlinx.coroutines.flow.Flow

class GetSearchResponseUseCase(private val repository: NewsResponseRepository) {
    operator fun invoke(): Flow<List<ResultSearchDomain>> {
        return repository.getSearchResultsFromRoom()
    }

    suspend fun initDatabase(searchTerm: String, typeOfSearch: Int) {

        if (typeOfSearch == 1) {
            repository.getTagsSearchResponse(searchTerm)
        } else if (typeOfSearch == 2) {
            repository.getSectionSearchResponse(searchTerm)
        }
    }
}