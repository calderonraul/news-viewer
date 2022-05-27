package com.example.news_viewer_compose_navigation_clean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.request.Tags
import com.example.data.model.ResultTags
import com.example.domain.entity.EditionDomain
import com.example.domain.entity.ResultDomain
import com.example.domain.entity.ResultTagsDomain
import com.example.news_viewer_compose_navigation_clean.presentation.NewsListUiState
import com.example.news_viewer_compose_navigation_clean.presentation.NewsResponseViewModel
import com.example.news_viewer_compose_navigation_clean.ui.theme.NewsviewercomposenavigationcleanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsviewercomposenavigationcleanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background

                ) {
                    InitFirstScreen()
                }
            }
        }
    }
}

@Composable
fun InitFirstScreen(viewModel: NewsResponseViewModel = hiltViewModel()) {
    //NewsList(state = viewModel.registerState)
    Tabs(state = viewModel.registerState)
}


@Composable
fun NewsItem(result: ResultDomain) {
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
                    Text(text = result.webTitle, style = MaterialTheme.typography.h4)
                    Text(text = result.webUrl, style = MaterialTheme.typography.subtitle1)
                }
            }
        }
    }
}

@Composable
fun TagItem(resultTags: ResultTagsDomain){
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
                    Text(text = resultTags.webTitle, style = MaterialTheme.typography.h4)
                    Text(text = resultTags.webUrl, style = MaterialTheme.typography.subtitle1)
                }
            }
        }
    }    
}

@Composable
fun NewsList(state: NewsListUiState, aux: String) {
    state.onWordValueChanged(aux)
    state.fetchMoreData()
    val newsList by state.newsFlows.collectAsState()
    LazyColumn() {
        itemsIndexed(newsList) { _, item ->
            NewsItem(result = item)
        }
    }
}

@Composable
fun TagsList(state: NewsListUiState) {
    state.fetchMoreData()
    val tagsList by state.tagsFlows.collectAsState()
    LazyColumn() {
        itemsIndexed(tagsList) { _, item ->
            TagItem(resultTags = item)
        }
    }
}


@Composable
fun Tabs(state: NewsListUiState) {
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("All news", "Business", "Football","Tags")
    val tabCategory = listOf("", "business", "football")
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
            0 -> NewsList(state = state, tabCategory[0])
            1 -> NewsList(state = state, tabCategory[1])
            2 -> NewsList(state = state, tabCategory[2])
            3 -> TagsList(state = state)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsviewercomposenavigationcleanTheme {
        val test = ResultDomain(
            id = "commentisfree",
            webTitle = "Opinion",
            webUrl = "https://www.theguardian.com/commentisfree",
            apiUrl = "https://content.guardianapis.com/commentisfree",
            editions = emptyList(),
            activeSponsorships = emptyList()
        )
        NewsItem(result = test)
    }
}