package com.example.news_viewer_compose_navigation_clean.presentation

import com.example.domain.entity.ResultDomain
import com.example.domain.entity.ResultTagsDomain
import kotlinx.coroutines.flow.StateFlow


data class NewsListUiState(
    val newsFlows: StateFlow<List<ResultDomain>>,
    val tagsFlows: StateFlow<List<ResultTagsDomain>>,
    val wordValue: StateFlow<String>,
    val onWordValueChanged: (String) -> Unit,
    val fetchMoreData: () -> Unit
)