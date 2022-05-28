package com.example.domain.entity.searchResponseDomain



data class ResultSearchDomain(
    val apiUrl: String,
    val fields: FieldsSearchDomain,
    val id: String,
    val isHosted: Boolean,
    val pillarId: String,
    val pillarName: String,
    val sectionId: String,
    val sectionName: String,
    val tags: List<TagSearchDomain>,
    val type: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String
)