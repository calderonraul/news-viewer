package com.example.data.api

import com.google.gson.annotations.SerializedName


data class ApiResponse<T>(
    @SerializedName("response")
    val newsResponse: T?
)

data class ApiResponseTags<T>(
    @SerializedName("response")
    val tagsResponse: T?
)

data class ApiResponseSearch<T>(
    @SerializedName("response")
    val searchResponse: T?
)

