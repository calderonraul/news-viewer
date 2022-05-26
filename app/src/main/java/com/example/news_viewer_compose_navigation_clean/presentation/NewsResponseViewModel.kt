package com.example.news_viewer_compose_navigation_clean.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.NewsResponseDomain
import com.example.domain.entity.ResultDomain
import com.example.domain.useCase.GetNewsResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsResponseViewModel @Inject constructor(private val getNewsResponseUseCase: GetNewsResponseUseCase) :
    ViewModel() {
    private val newsData: MutableStateFlow<List<ResultDomain>> = MutableStateFlow(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getNewsResponseUseCase.initDB()
        }
    }

    private fun fetchList() {
        viewModelScope.launch(Dispatchers.IO) {
            getNewsResponseUseCase.invoke().collect {
                newsData.value = it
            }
        }
    }

    val registerState = NewsListUiState(
        newsFlows = newsData,
        fetchMoreData = this::fetchList

    )
}