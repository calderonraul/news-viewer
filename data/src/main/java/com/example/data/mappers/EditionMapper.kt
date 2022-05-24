package com.example.data.mappers

import com.example.data.model.Edition
import com.example.domain.entity.EditionDomain

class EditionMapper : EntityMapper<Edition, EditionDomain> {
    override fun mapFromEntity(entity: Edition): EditionDomain {
        return EditionDomain(
            apiUrl = entity.apiUrl,
            code = entity.code,
            id = entity.id,
            webTitle = entity.webTitle,
            webUrl = entity.webUrl
        )
    }

    override fun mapToEntity(domainModel: EditionDomain): Edition {
        return Edition(
            apiUrl = domainModel.apiUrl,
            code = domainModel.code,
            id = domainModel.id,
            webTitle = domainModel.webTitle,
            webUrl = domainModel.webUrl
        )
    }

    fun fromEntityList(initial: List<Edition>): List<EditionDomain> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<EditionDomain>): List<Edition> {
        return initial.map { mapToEntity(it) }
    }
}