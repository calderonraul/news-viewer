package com.example.data.mappers

import com.example.data.model.Result
import com.example.domain.entity.ResultDomain

class ResultMapper : EntityMapper<Result, ResultDomain> {
    override fun mapFromEntity(entity: Result): ResultDomain {
        return ResultDomain(
            activeSponsorships = entity.activeSponsorships?.let {
                ActiveSponsorShipMapper().fromEntityList(
                    it
                )
            },
            apiUrl = entity.apiUrl,
            editions = EditionMapper().fromEntityList(entity.editions),
            id = entity.id,
            webTitle = entity.webTitle,
            webUrl = entity.webUrl
        )
    }

    override fun mapToEntity(domainModel: ResultDomain): Result {
        return Result(
            activeSponsorships = domainModel.activeSponsorships?.let {
                ActiveSponsorShipMapper().toEntityList(
                    it
                )
            },
            apiUrl = domainModel.apiUrl,
            editions = EditionMapper().toEntityList(domainModel.editions),
            id = domainModel.id,
            webTitle = domainModel.webTitle,
            webUrl = domainModel.webUrl
        )
    }

    fun fromEntityList(initial: List<Result>): List<ResultDomain> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<ResultDomain>): List<Result> {
        return initial.map { mapToEntity(it) }
    }

}