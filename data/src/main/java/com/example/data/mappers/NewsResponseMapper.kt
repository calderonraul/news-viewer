package com.example.data.mappers

import com.example.data.model.NewsResponse
import com.example.domain.entity.NewsResponseDomain

class NewsResponseMapper : EntityMapper<NewsResponse, NewsResponseDomain> {
    override fun mapFromEntity(entity: NewsResponse): NewsResponseDomain {
        return NewsResponseDomain(
            response = ResponseMapper().mapFromEntity(entity.response)
        )
    }

    override fun mapToEntity(domainModel: NewsResponseDomain): NewsResponse {
        return NewsResponse(
            response = ResponseMapper().mapToEntity(domainModel.response)
        )
    }
}