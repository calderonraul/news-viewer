package com.example.data.mappers.tagsResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.model.HighContrastSponsorLogoDimensions
import com.example.data.model.SponsorLogoDimensionsTag
import com.example.domain.entity.HighContrastSponsorLogoDimensionsDomain

class HighContrastSponsorLogoDimensionsTagMapper :
    EntityMapper<HighContrastSponsorLogoDimensions, HighContrastSponsorLogoDimensionsDomain> {
    override fun mapFromEntity(entity:HighContrastSponsorLogoDimensions): HighContrastSponsorLogoDimensionsDomain {
        return HighContrastSponsorLogoDimensionsDomain(
            height = entity.height,
            width = entity.width
        )
    }

    override fun mapToEntity(domainModel: HighContrastSponsorLogoDimensionsDomain): HighContrastSponsorLogoDimensions {
        return HighContrastSponsorLogoDimensions(
            height = domainModel.height,
            width = domainModel.width
        )
    }
}