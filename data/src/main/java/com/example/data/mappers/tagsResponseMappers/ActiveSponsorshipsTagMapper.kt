package com.example.data.mappers.tagsResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.model.ActiveSponsorshipTag
import com.example.domain.entity.ActiveSponsorshipTagDomain

class ActiveSponsorshipsTagMapper : EntityMapper<ActiveSponsorshipTag, ActiveSponsorshipTagDomain> {
    override fun mapFromEntity(entity: ActiveSponsorshipTag): ActiveSponsorshipTagDomain {
        return ActiveSponsorshipTagDomain(
            aboutLink = entity.aboutLink,
            highContrastSponsorLogo = entity.highContrastSponsorLogo,
            sponsorLink = entity.sponsorLink,
            sponsorLogo = entity.sponsorLogo,
            sponsorName = entity.sponsorName,
            highContrastSponsorLogoDimensions = entity.highContrastSponsorLogoDimensions?.let {
                HighContrastSponsorLogoDimensionsTagMapper().mapFromEntity(
                    it
                )
            },
            sponsorLogoDimensions = SponsorLogoDimensionsTagMapper().mapFromEntity(entity.sponsorLogoDimensions),
            sponsorshipType = entity.sponsorshipType,
            validTo = entity.validTo
        )
    }

    override fun mapToEntity(domainModel: ActiveSponsorshipTagDomain): ActiveSponsorshipTag {
        return ActiveSponsorshipTag(
            aboutLink = domainModel.aboutLink,
            highContrastSponsorLogo = domainModel.highContrastSponsorLogo,
            sponsorLink = domainModel.sponsorLink,
            sponsorLogo = domainModel.sponsorLogo,
            sponsorName = domainModel.sponsorName,
            highContrastSponsorLogoDimensions = domainModel.highContrastSponsorLogoDimensions?.let {
                HighContrastSponsorLogoDimensionsTagMapper().mapToEntity(
                    it
                )
            },
            sponsorLogoDimensions = domainModel.sponsorLogoDimensions?.let {
                SponsorLogoDimensionsTagMapper().mapToEntity(
                    it
                )
            },
            sponsorshipType = domainModel.sponsorshipType,
            validTo = domainModel.validTo
        )
    }

    fun fromEntityList(initial: List<ActiveSponsorshipTag>): List<ActiveSponsorshipTagDomain> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<ActiveSponsorshipTagDomain>): List<ActiveSponsorshipTag> {
        return initial.map { mapToEntity(it) }
    }

}