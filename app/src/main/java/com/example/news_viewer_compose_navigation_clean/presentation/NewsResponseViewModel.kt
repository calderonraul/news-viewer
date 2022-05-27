package com.example.news_viewer_compose_navigation_clean.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.NewsResponseDomain
import com.example.domain.entity.ResultDomain
import com.example.domain.entity.ResultTagsDomain
import com.example.domain.useCase.GetNewsResponseUseCase
import com.example.domain.useCase.GetTagsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsResponseViewModel @Inject constructor(
    private val getNewsResponseUseCase: GetNewsResponseUseCase,
    private val getTagsUseCase: GetTagsUseCase
) :
    ViewModel() {
    private val wordValueFlow: MutableStateFlow<String> = MutableStateFlow("")
    private val newsData: MutableStateFlow<List<ResultDomain>> = MutableStateFlow(emptyList())
    private val tagsData: MutableStateFlow<List<ResultTagsDomain>> = MutableStateFlow(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getNewsResponseUseCase.initDB()
            getNewsResponseUseCase.invoke(wordValueFlow.value).collect {
                newsData.value = it
            }

        }
        viewModelScope.launch (Dispatchers.IO){
            getTagsUseCase.initDbTags()
            getTagsUseCase.invoke().collect {
                tagsData.value = it
            }
        }
    }

    private fun fetchList() {
        viewModelScope.launch(Dispatchers.IO) {
            getNewsResponseUseCase.invoke(wordValueFlow.value).collect {
                newsData.value = it
            }
        }
    }

    private fun fetchTags() {
        viewModelScope.launch(Dispatchers.IO) {
            getTagsUseCase.invoke().collect {
                tagsData.value = it
            }
        }
    }

    private fun onWordChanged(value: String) {
        wordValueFlow.value = value
    }

    val registerState = NewsListUiState(
        newsFlows = newsData,
        wordValue = wordValueFlow,
        onWordValueChanged = this::onWordChanged,
        fetchMoreData = this::fetchList,
        tagsFlows = tagsData

    )
}