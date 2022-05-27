package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class ResponseTags(
    val currentPage: Int,
    val pageSize: Int,
    val pages: Int,
    val results: List<ResultTags>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String
)

@Entity("results_tags_table")
data class ResultTags(
    val activeSponsorships: List<ActiveSponsorshipTag>?,
    val apiUrl: String,
    val description: String?,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val paidContentType: String?,
    val sectionId: String?,
    val sectionName: String?,
    val type: String,
    val webTitle: String,
    val webUrl: String
)

data class ActiveSponsorshipTag(
    val aboutLink: String?,
    val highContrastSponsorLogo: String?,
    val highContrastSponsorLogoDimensions: HighContrastSponsorLogoDimensions?,
    val sponsorLink: String,
    val sponsorLogo: String,
    val sponsorLogoDimensions: SponsorLogoDimensionsTag?,
    val sponsorName: String,
    val sponsorshipType: String,
    val validTo: String?
)

data class HighContrastSponsorLogoDimensions(
    val height: Int,
    val width: Int
)

data class SponsorLogoDimensionsTag(
    val height: Int,
    val width: Int
)