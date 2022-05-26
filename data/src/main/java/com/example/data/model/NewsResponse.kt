package com.example.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


data class NewsResponse(
    val response: Response
)

data class Response(
    val results: List<Result>,
    val status: String,
    val total: Int,
    val userTier: String
)

@Entity(tableName = "results_table")
data class Result(
    val activeSponsorships: List<ActiveSponsorship>,
    val apiUrl: String,
    val editions: List<Edition>,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String,
    val webTitle: String,
    val webUrl: String,
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