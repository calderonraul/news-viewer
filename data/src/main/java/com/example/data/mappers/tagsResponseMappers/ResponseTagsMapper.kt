package com.example.data.mappers.tagsResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.mappers.newsResponseMappers.ResultMapper
import com.example.data.model.ResponseTags
import com.example.data.model.ResultTags
import com.example.data.model.SponsorLogoDimensionsTag
import com.example.domain.entity.ResponseTagsDomain

class ResponseTagsMapper : EntityMapper<ResponseTags, ResponseTagsDomain> {
    override fun mapFromEntity(entity: ResponseTags): ResponseTagsDomain {
        return ResponseTagsDomain(
            currentPage = entity.currentPage,
            pageSize = entity.pageSize,
            pages = entity.pages,
            results = ResultTagsMapper().fromEntityList(entity.results) ,
            startIndex = entity.startIndex,
            status = entity.status,
            total = entity.total,
            userTier = entity.userTier
        )
    }

    override fun mapToEntity(domainModel: ResponseTagsDomain): ResponseTags {
        return ResponseTags(
            currentPage = domainModel.currentPage,
            pageSize = domainModel.pageSize,
            pages = domainModel.pages,
            results = emptyList(),
            startIndex = domainModel.startIndex,
            status = domainModel.status,
            total = domainModel.total,
            userTier = domainModel.userTier
        )
    }
}