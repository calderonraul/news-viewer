package com.example.news_viewer_compose_navigation_clean

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.entity.searchResponseDomain.ResultSearchDomain
import com.example.news_viewer_compose_navigation_clean.presentation.NewsListUiState
import com.example.news_viewer_compose_navigation_clean.presentation.NewsResponseViewModel


@Composable
fun NewsItem(result: ResultSearchDomain) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Surface() {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            ) {
                Column() {
                    Text(text = result.webTitle, style = MaterialTheme.typography.h6)
                    Text(text = result.webUrl, style = MaterialTheme.typography.subtitle1)
                }
            }
        }
    }
}

@Composable
fun NewsList(state: NewsListUiState, aux: String, typeOfSearch: Int) {
    state.onNumValueChanged(typeOfSearch)
    state.onWordValueChanged(aux)
    state.fetchMoreData()
    val newsList by state.searchFlow.collectAsState()
    LazyColumn() {
        itemsIndexed(newsList) { _, item ->
            NewsItem(result = item)
        }
    }
}


@Composable
fun TabsTech(state: NewsListUiState) {
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("All news", "Android", "Apple")
    val tabCategory = listOf("technology", "technology/android", "technology/apple")
    Column { // 2.

        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> NewsList(state = state, tabCategory[0], 2)
            1 -> NewsList(state = state, tabCategory[1], 1)
            2 -> NewsList(state = state, tabCategory[2], 1)
        }
    }
}

@Composable
fun TabsBusiness(state: NewsListUiState) {
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("All news", "adams", "Accountancy")
    val tabCategory = listOf("business", "business/adams", "business/accountancy")
    Column { // 2.
        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> NewsList(state = state, tabCategory[0], 2)
            1 -> NewsList(state = state, tabCategory[1], 1)
            2 -> NewsList(state = state, tabCategory[2], 1)
        }
    }
}


@Composable
fun TabsFootball(state: NewsListUiState) {
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("All news", "Chelsea", "UCL")
    val tabCategory = listOf("football", "football/chelsea", "football/championsleague")
    Column { // 2.

        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> NewsList(state = state, tabCategory[0], 2)
            1 -> NewsList(state = state, tabCategory[1], 1)
            2 -> NewsList(state = state, tabCategory[2], 1)
        }
    }
}


@Composable
fun TabsMusic(state: NewsListUiState) {
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("All news", "Taylor Swift", "Adele")
    val tabCategory = listOf("music", "music/taylor-swift", "music/adele")
    Column { // 2.

        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> NewsList(state = state, tabCategory[0], 2)
            1 -> NewsList(state = state, tabCategory[1], 1)
            2 -> NewsList(state = state, tabCategory[2], 1)
        }
    }
}


@Composable
fun TabsPolitics(state: NewsListUiState) {
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("All news", "Adam Smith", "aitken")
    val tabCategory = listOf("politics", "politics/adam-smith", "politics/aitken")
    Column { // 2.

        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> NewsList(state = state, tabCategory[0], 2)
            1 -> NewsList(state = state, tabCategory[1], 1)
            2 -> NewsList(state = state, tabCategory[2], 1)
        }
    }
}

@Composable
fun InitTechScreen(viewModel: NewsResponseViewModel = hiltViewModel(), openDrawer: () -> Unit) {
    Column() {
        TopBar(title = "Tech", buttonIcon = Icons.Filled.List, onButtonClicked = { openDrawer() })
        TabsTech(state = viewModel.registerState)
    }
}


@Composable
fun InitBusinessScreen(viewModel: NewsResponseViewModel = hiltViewModel(), openDrawer: () -> Unit) {
    Column() {
        TopBar(title = "Business", buttonIcon = Icons.Filled.List, onButtonClicked = { openDrawer() })
        TabsBusiness(state = viewModel.registerState)
    }
}


@Composable
fun InitFootballScreen(viewModel: NewsResponseViewModel = hiltViewModel(), openDrawer: () -> Unit) {
    Column() {
        TopBar(title = "Football", buttonIcon = Icons.Filled.List, onButtonClicked = { openDrawer() })
        TabsFootball(state = viewModel.registerState)
    }
}


@Composable
fun InitMusicScreen(viewModel: NewsResponseViewModel = hiltViewModel(), openDrawer: () -> Unit) {
    Column() {
        TopBar(title = "Music", buttonIcon = Icons.Filled.List, onButtonClicked = { openDrawer() })
        TabsMusic(state = viewModel.registerState)
    }
}
@Composable
fun InitPoliticsScreen(viewModel: NewsResponseViewModel = hiltViewModel(), openDrawer: () -> Unit) {
    Column() {
        TopBar(title = "Politics", buttonIcon = Icons.Filled.List, onButtonClicked = { openDrawer() })
        TabsPolitics(state = viewModel.registerState)
    }
}
