package com.example.data.mappers

import com.example.data.model.ActiveSponsorship
import com.example.domain.entity.ActiveSponsorshipDomain

class ActiveSponsorShipMapper : EntityMapper<ActiveSponsorship, ActiveSponsorshipDomain> {
    override fun mapFromEntity(entity: ActiveSponsorship): ActiveSponsorshipDomain {
        return ActiveSponsorshipDomain(
            aboutLink = entity.aboutLink,
            sponsorLink = entity.sponsorLink,
            sponsorLogo = entity.sponsorLogo,
            sponsorLogoDimensions = SponsorLogoDimensionsMapper().mapFromEntity(entity.sponsorLogoDimensions),
            sponsorName = entity.sponsorName,
            sponsorshipType = entity.sponsorshipType,
            validFrom = entity.validFrom,
            validTo = entity.validTo
        )
    }

    override fun mapToEntity(domainModel: ActiveSponsorshipDomain): ActiveSponsorship {
        return ActiveSponsorship(
            aboutLink = domainModel.aboutLink,
            sponsorLink = domainModel.sponsorLink,
            sponsorLogo = domainModel.sponsorLogo,
            sponsorLogoDimensions = SponsorLogoDimensionsMapper().mapToEntity(domainModel.sponsorLogoDimensions),
            sponsorName = domainModel.sponsorName,
            sponsorshipType = domainModel.sponsorshipType,
            validFrom = domainModel.validFrom,
            validTo = domainModel.validTo
        )
    }

    fun fromEntityList(initial: List<ActiveSponsorship>): List<ActiveSponsorshipDomain> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<ActiveSponsorshipDomain>): List<ActiveSponsorship> {
        return initial.map { mapToEntity(it) }
    }
}