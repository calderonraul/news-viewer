package com.example.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters() {

    @TypeConverter
    fun toNewsResponseJson(newsResponse: NewsResponse): String = Gson().toJson(newsResponse)

    @TypeConverter
    fun fromNewsResponseJson(json: String): NewsResponse =
        Gson().fromJson(json, NewsResponse::class.java)

}