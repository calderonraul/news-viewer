package com.example.data.mappers.searchResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.model.searchResponse.ResultSearch
import com.example.data.model.searchResponse.TagSearch
import com.example.domain.entity.searchResponseDomain.ResultSearchDomain
import com.example.domain.entity.searchResponseDomain.TagSearchDomain


class ResultSearchMapper : EntityMapper<ResultSearch, ResultSearchDomain> {
    override fun mapFromEntity(entity: ResultSearch): ResultSearchDomain {
        return ResultSearchDomain(
            apiUrl = entity.apiUrl,
            fields = entity.fields?.let { FieldSearchMapper().mapFromEntity(it) },
            id = entity.id,
            isHosted = entity.isHosted,
            pillarId = entity.pillarId,
            pillarName = entity.pillarName,
            sectionId = entity.sectionId,
            sectionName = entity.sectionName,
            tags = entity.tags?.let { TagSearchMapper().fromEntityList(it) },
            type = entity.type,
            webPublicationDate = entity.webPublicationDate,
            webTitle = entity.webTitle,
            webUrl = entity.webUrl
        )
    }

    override fun mapToEntity(domainModel: ResultSearchDomain): ResultSearch {
        return ResultSearch(
            apiUrl = domainModel.apiUrl,
            fields = domainModel.fields?.let { FieldSearchMapper().mapToEntity(it) },
            id = domainModel.id,
            isHosted = domainModel.isHosted,
            pillarId = domainModel.pillarId,
            pillarName = domainModel.pillarName,
            sectionId = domainModel.sectionId,
            sectionName = domainModel.sectionName,
            tags = domainModel.tags?.let { TagSearchMapper().toEntityList(it) },
            type = domainModel.type,
            webPublicationDate = domainModel.webPublicationDate,
            webTitle = domainModel.webTitle,
            webUrl = domainModel.webUrl
        )
    }


    fun fromEntityList(initial: List<ResultSearch>): List<ResultSearchDomain> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<ResultSearchDomain>): List<ResultSearch> {
        return initial.map { mapToEntity(it) }
    }
}