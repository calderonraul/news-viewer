package com.example.data.mappers

import com.example.data.model.SponsorLogoDimensionsTag

interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}