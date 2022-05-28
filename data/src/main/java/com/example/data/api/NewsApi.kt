package com.example.data.api

import com.example.data.model.NewsResponse
import com.example.data.model.Response
import com.example.data.model.ResponseTags
import com.example.data.model.searchResponse.ResponseSearch
import com.example.data.model.searchResponse.ResultSearch
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {

    @GET("sections")
    suspend fun getAllNews():ApiResponse<Response>

    @GET("tags")
    suspend fun getAllTags():ApiResponseTags<ResponseTags>

    @GET("search")
    suspend fun getAllNewsByTag(@Query("tag")tagParam:String):ApiResponseTags<ResponseSearch>


}