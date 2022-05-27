package com.example.domain.entity



data class ResponseTagsDomain(
    val currentPage: Int,
    val pageSize: Int,
    val pages: Int,
    val results: List<ResultTagsDomain>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String
)

data class ResultTagsDomain(
    val activeSponsorships: List<ActiveSponsorshipTagDomain>?,
    val apiUrl: String,
    val description: String?,
    val id: String,
    val paidContentType: String?,
    val sectionId: String?,
    val sectionName: String?,
    val type: String,
    val webTitle: String,
    val webUrl: String
)

data class ActiveSponsorshipTagDomain(
    val aboutLink: String?,
    val highContrastSponsorLogo: String?,
    val highContrastSponsorLogoDimensions: HighContrastSponsorLogoDimensionsDomain?,
    val sponsorLink: String,
    val sponsorLogo: String,
    val sponsorLogoDimensions: SponsorLogoDimensionsTagDomain?,
    val sponsorName: String,
    val sponsorshipType: String,
    val validTo: String?
)

data class HighContrastSponsorLogoDimensionsDomain(
    val height: Int,
    val width: Int
)

data class SponsorLogoDimensionsTagDomain(
    val height: Int,
    val width: Int
)