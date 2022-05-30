package com.example.news_viewer_compose_navigation_clean.presentation

import com.example.domain.entity.searchResponseDomain.ResultSearchDomain
import kotlinx.coroutines.flow.StateFlow


data class NewsListUiState(
    val searchFlow: StateFlow<List<ResultSearchDomain>>,
    val wordValue: StateFlow<String>,
    val onWordValueChanged: (String) -> Unit,
    val numValue:StateFlow<Int>,
    val onNumValueChanged: (Int)->Unit,
    val fetchMoreData: () -> Unit,
    val fetchTitleData: ()->Unit
)