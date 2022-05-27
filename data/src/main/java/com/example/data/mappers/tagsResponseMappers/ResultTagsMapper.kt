package com.example.data.mappers.tagsResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.model.ResultTags
import com.example.data.model.SponsorLogoDimensionsTag
import com.example.domain.entity.ResultTagsDomain

class ResultTagsMapper : EntityMapper<ResultTags, ResultTagsDomain> {
    override fun mapFromEntity(entity: ResultTags): ResultTagsDomain {
        return ResultTagsDomain(
            apiUrl = entity.apiUrl,
            activeSponsorships = entity.activeSponsorships?.let {
                ActiveSponsorshipsTagMapper().fromEntityList(
                    it
                )
            },
            description = entity.description,
            id = entity.id,
            paidContentType = entity.paidContentType,
            sectionId = entity.sectionId,
            sectionName = entity.sectionName,
            type = entity.type,
            webTitle = entity.webTitle,
            webUrl = entity.webUrl
        )
    }

    override fun mapToEntity(domainModel: ResultTagsDomain): ResultTags {
        return ResultTags(
            apiUrl = domainModel.apiUrl,
            activeSponsorships = domainModel.activeSponsorships?.let {
                ActiveSponsorshipsTagMapper().toEntityList(
                    it
                )
            },
            description = domainModel.description,
            id = domainModel.id,
            paidContentType = domainModel.paidContentType,
            sectionId = domainModel.sectionId,
            sectionName = domainModel.sectionName,
            type = domainModel.type,
            webTitle = domainModel.webTitle,
            webUrl = domainModel.webUrl

        )
    }

    fun fromEntityList(initial: List<ResultTags>): List<ResultTagsDomain> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<ResultTagsDomain>): List<ResultTags> {
        return initial.map { mapToEntity(it) }
    }
}