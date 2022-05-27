package com.example.data.mappers.newsResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.model.SponsorLogoDimensions
import com.example.data.model.SponsorLogoDimensionsTag
import com.example.domain.entity.SponsorLogoDimensionsDomain

class SponsorLogoDimensionsMapper :
    EntityMapper<SponsorLogoDimensions, SponsorLogoDimensionsDomain> {
    override fun mapFromEntity(entity: SponsorLogoDimensions): SponsorLogoDimensionsDomain {
        return SponsorLogoDimensionsDomain(
            height = entity.height,
            width = entity.width
        )
    }

    override fun mapToEntity(domainModel: SponsorLogoDimensionsDomain): SponsorLogoDimensions {
        return SponsorLogoDimensions(
            height = domainModel.height,
            width = domainModel.width
        )
    }
}