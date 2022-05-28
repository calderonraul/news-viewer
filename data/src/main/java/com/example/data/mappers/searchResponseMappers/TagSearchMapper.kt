package com.example.data.mappers.searchResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.model.Result
import com.example.data.model.searchResponse.TagSearch
import com.example.domain.entity.ResultDomain
import com.example.domain.entity.searchResponseDomain.TagSearchDomain

class TagSearchMapper : EntityMapper<TagSearch, TagSearchDomain> {
    override fun mapFromEntity(entity: TagSearch): TagSearchDomain {
        return TagSearchDomain(
            apiUrl = entity.apiUrl,
            bio = entity.bio,
            bylineImageUrl = entity.bylineImageUrl,
            bylineLargeImageUrl = entity.bylineLargeImageUrl,
            firstName = entity.firstName,
            id = entity.id,
            lastName = entity.lastName,
            references = emptyList(),
            twitterHandle = entity.twitterHandle,
            type = entity.type,
            webTitle = entity.webTitle,
            webUrl = entity.webUrl
        )
    }

    override fun mapToEntity(domainModel: TagSearchDomain): TagSearch {
        return TagSearch(
            apiUrl = domainModel.apiUrl,
            bio = domainModel.bio,
            bylineImageUrl = domainModel.bylineImageUrl,
            bylineLargeImageUrl = domainModel.bylineLargeImageUrl,
            firstName = domainModel.firstName,
            id = domainModel.id,
            lastName = domainModel.lastName,
            references = emptyList(),
            twitterHandle = domainModel.twitterHandle,
            type = domainModel.type,
            webTitle = domainModel.webTitle,
            webUrl = domainModel.webUrl
        )
    }


    fun fromEntityList(initial: List<TagSearch>): List<TagSearchDomain> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<TagSearchDomain>): List<TagSearch> {
        return initial.map { mapToEntity(it) }
    }
}