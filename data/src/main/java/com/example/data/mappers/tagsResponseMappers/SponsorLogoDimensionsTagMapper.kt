package com.example.data.mappers.tagsResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.model.SponsorLogoDimensionsTag
import com.example.domain.entity.SponsorLogoDimensionsTagDomain

class SponsorLogoDimensionsTagMapper :
    EntityMapper<SponsorLogoDimensionsTag?, SponsorLogoDimensionsTagDomain> {
    override fun mapFromEntity(entity: SponsorLogoDimensionsTag?): SponsorLogoDimensionsTagDomain {
        if (entity != null) {
            return SponsorLogoDimensionsTagDomain(
                height = entity.height,
                width = entity.width
            )
        }else{
            return SponsorLogoDimensionsTagDomain(
                height = 0,
                width = 0
            )
        }
    }

    override fun mapToEntity(domainModel: SponsorLogoDimensionsTagDomain): SponsorLogoDimensionsTag? {
        return SponsorLogoDimensionsTag(
            height = domainModel.height,
            width = domainModel.width
        )
    }
}