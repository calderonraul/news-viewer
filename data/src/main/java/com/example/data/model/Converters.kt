package com.example.data.model

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters() {

    @TypeConverter
    fun toNewsResponseJson(result: List<Result>): String {
        return Gson().toJson(
            result,
            object : TypeToken<List<Result>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromNewsResponseJson(json: String): List<Result> {
        return Gson().fromJson<List<Result>>(
            json,
            object : TypeToken<List<Result>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toSponsorship(activeSponsorship: List<ActiveSponsorship>?): String {
        return Gson().toJson(
            activeSponsorship,
            object : TypeToken<List<ActiveSponsorship>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromSponsorshipJson(json: String): List<ActiveSponsorship> {
        return Gson().fromJson<List<ActiveSponsorship>>(
            json,
            object : TypeToken<List<ActiveSponsorship>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toEditions(edition: List<Edition>): String {
        return Gson().toJson(
            edition,
            object : TypeToken<List<Edition>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromEditionJson(json: String): List<Edition> {
        return Gson().fromJson<List<Edition>>(
            json,
            object : TypeToken<List<Edition>>() {}.type
        ) ?: emptyList()
    }


}