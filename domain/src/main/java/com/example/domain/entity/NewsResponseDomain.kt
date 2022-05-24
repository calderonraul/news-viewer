package com.example.domain.entity

data class NewsResponseDomain(
    val response: ResponseDomain
)

data class ResponseDomain(
    val results: List<ResultDomain>,
    val status: String,
    val total: Int,
    val userTier: String
)

data class ResultDomain(
    val activeSponsorships: List<ActiveSponsorshipDomain>,
    val apiUrl: String,
    val editions: List<EditionDomain>,
    val id: String,
    val webTitle: String,
    val webUrl: String
)

data class ActiveSponsorshipDomain(
    val aboutLink: String,
    val sponsorLink: String,
    val sponsorLogo: String,
    val sponsorLogoDimensions: SponsorLogoDimensionsDomain,
    val sponsorName: String,
    val sponsorshipType: String,
    val validFrom: String,
    val validTo: String
)

data class EditionDomain(
    val apiUrl: String,
    val code: String,
    val id: String,
    val webTitle: String,
    val webUrl: String
)

data class SponsorLogoDimensionsDomain(
    val height: Int,
    val width: Int
)