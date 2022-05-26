package com.example.data.api

import com.example.data.model.NewsResponse
import com.example.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    @GET("sections")
    suspend fun getAllNews():ApiResponse<Response>


}