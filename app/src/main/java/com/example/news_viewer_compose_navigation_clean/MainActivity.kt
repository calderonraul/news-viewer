package com.example.news_viewer_compose_navigation_clean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.entity.ResultDomain
import com.example.news_viewer_compose_navigation_clean.presentation.NewsListUiState
import com.example.news_viewer_compose_navigation_clean.presentation.NewsResponseViewModel
import com.example.news_viewer_compose_navigation_clean.ui.theme.NewsviewercomposenavigationcleanTheme
import com.example.news_viewer_compose_navigation_clean.ui.theme.Typography
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

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
    NewsList(state = viewModel.registerState)
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
fun NewsList(state: NewsListUiState) {
    val newsList by state.newsFlows.collectAsState()


    LazyColumn() {
        itemsIndexed(newsList) { _, item ->
            NewsItem(result = item)
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