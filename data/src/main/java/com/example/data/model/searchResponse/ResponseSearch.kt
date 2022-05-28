package com.example.data.model.searchResponse

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ResponseSearch(
    val currentPage: Int,
    val orderBy: String,
    val pageSize: Int,
    val pages: Int,
    val results: List<ResultSearch>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String
)
