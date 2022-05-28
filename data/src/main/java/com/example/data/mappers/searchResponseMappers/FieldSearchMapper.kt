package com.example.data.mappers.searchResponseMappers

import com.example.data.mappers.EntityMapper
import com.example.data.model.searchResponse.FieldsSearch
import com.example.domain.entity.searchResponseDomain.FieldsSearchDomain

class FieldSearchMapper : EntityMapper<FieldsSearch, FieldsSearchDomain> {
    override fun mapFromEntity(entity: FieldsSearch): FieldsSearchDomain {
        return FieldsSearchDomain(
            headline = entity.headline,
            shortUrl = entity.shortUrl,
            thumbnail = entity.thumbnail
        )
    }

    override fun mapToEntity(domainModel: FieldsSearchDomain): FieldsSearch {
        return FieldsSearch(
            headline = domainModel.headline,
            shortUrl = domainModel.shortUrl,
            thumbnail = domainModel.thumbnail
        )
    }
}