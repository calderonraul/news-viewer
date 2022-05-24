package com.example.data.api

import com.example.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("https://content.guardianapis.com/sections")
    suspend fun getAllNews(@Query("api_key") apiKey:String):ApiResponse<NewsResponse>

}