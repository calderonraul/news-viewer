package com.example.data.model

import androidx.room.Entity

@Entity(tableName = "response_table")
data class NewsResponse(
    val response: Response
)

data class Response(
    val results: List<Result>,
    val status: String,
    val total: Int,
    val userTier: String
)

data class Result(
    val activeSponsorships: List<ActiveSponsorship>,
    val apiUrl: String,
    val editions: List<Edition>,
    val id: String,
    val webTitle: String,
    val webUrl: String
)

data class ActiveSponsorship(
    val aboutLink: String,
    val sponsorLink: String,
    val sponsorLogo: String,
    val sponsorLogoDimensions: SponsorLogoDimensions,
    val sponsorName: String,
    val sponsorshipType: String,
    val validFrom: String,
    val validTo: String
)

data class Edition(
    val apiUrl: String,
    val code: String,
    val id: String,
    val webTitle: String,
    val webUrl: String
)

data class SponsorLogoDimensions(
    val height: Int,
    val width: Int
)