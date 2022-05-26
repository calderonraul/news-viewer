package com.example.data.api

import com.example.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {

    @GET("sections")
    suspend fun getAllNews():ApiResponse<NewsResponse>

}