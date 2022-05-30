package com.example.news_viewer_compose_navigation_clean.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.searchResponseDomain.ResultSearchDomain
import com.example.domain.useCase.GetSearchResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsResponseViewModel @Inject constructor(
    private val getSearchResponseUseCase: GetSearchResponseUseCase
) :
    ViewModel() {
    private val wordValueFlow: MutableStateFlow<String> = MutableStateFlow("")
    private val numValueFlow: MutableStateFlow<Int> = MutableStateFlow(0)
    private val searchResultsData: MutableStateFlow<List<ResultSearchDomain>> =
        MutableStateFlow(emptyList())


    private fun fetchList() {
        viewModelScope.launch(Dispatchers.IO) {
            getSearchResponseUseCase.initDatabase(wordValueFlow.value,numValueFlow.value)
            getSearchResponseUseCase.invoke().collect {
                searchResultsData.value = it
            }
        }
    }


    private fun onWordChanged(value: String) {
        wordValueFlow.value = value
    }

    private fun onNumChanged(value: Int) {
        numValueFlow.value = value
    }


    val registerState = NewsListUiState(
        searchResultsData,
        wordValue = wordValueFlow,
        onWordValueChanged = this::onWordChanged,
        fetchMoreData = this::fetchList,
        numValue = numValueFlow,
        onNumValueChanged = this::onNumChanged
    )
}