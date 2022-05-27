package com.example.data.mappers.newsResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.model.Response
import com.example.data.model.SponsorLogoDimensionsTag
import com.example.domain.entity.ResponseDomain

class ResponseMapper : EntityMapper<Response, ResponseDomain> {
    override fun mapFromEntity(entity: Response): ResponseDomain {
        return ResponseDomain(
            results = ResultMapper().fromEntityList(entity.results),
            status = entity.status,
            total = entity.total,
            userTier = entity.userTier
        )
    }

    override fun mapToEntity(domainModel: ResponseDomain): Response {
        return Response(
            results = ResultMapper().toEntityList(domainModel.results),
            status = domainModel.status,
            total = domainModel.total,
            userTier = domainModel.userTier
        )
    }

}