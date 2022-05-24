package com.example.data.api



data class ApiResponse<T>(
    val newsResponse: List<T>?
)
