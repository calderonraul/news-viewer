package com.example.data.api

import com.google.gson.annotations.SerializedName


data class ApiResponse<T>(

    @SerializedName("response")
    val newsResponse: T?
)
