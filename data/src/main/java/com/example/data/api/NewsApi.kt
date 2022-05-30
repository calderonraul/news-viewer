package com.example.data.api

import com.example.data.model.searchResponse.ResponseSearch
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("search")
    suspend fun getAllNewsByTag(@Query("tag")tagParam:String):ApiResponseTags<ResponseSearch>

    @GET("search")
    suspend fun getAllNewsBySection(@Query("section")tagParam:String):ApiResponseTags<ResponseSearch>

}