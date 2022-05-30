package com.example.data.model

import androidx.room.TypeConverter
import com.example.data.model.searchResponse.FieldsSearch
import com.example.data.model.searchResponse.TagSearch
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters() {


    @TypeConverter
    fun toTag(tags: List<TagSearch>?): String {
        return Gson().toJson(
            tags,
            object : TypeToken<List<TagSearch>?>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromTagJson(json: String): List<TagSearch>? {
        return Gson().fromJson<List<TagSearch>>(
            json,
            object : TypeToken<List<TagSearch>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toField(fieldsSearch: FieldsSearch?): String {
        return Gson().toJson(
            fieldsSearch,
            object :TypeToken<FieldsSearch>() {}.type
        ) ?:""
    }

    @TypeConverter
    fun fromFieldJson(json: String):FieldsSearch?{
        return Gson().fromJson<FieldsSearch>(
            json,
            object :TypeToken<FieldsSearch>() {}.type
        )
    }


}