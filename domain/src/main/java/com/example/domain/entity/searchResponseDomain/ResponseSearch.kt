package com.example.domain.entity.searchResponseDomain

data class ResponseSearchDomain(
    val currentPage: Int,
    val orderBy: String,
    val pageSize: Int,
    val pages: Int,
    val results: List<ResultSearchDomain>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String
)
