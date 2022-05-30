package com.example.data.model.searchResponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("result_search_table")
data class ResultSearch(
    val apiUrl: String,
    val fields: FieldsSearch?,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val isHosted: Boolean,
    val pillarId: String,
    val pillarName: String,
    val sectionId: String,
    val sectionName: String,
    val tags: List<TagSearch>?,
    val type: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String
)