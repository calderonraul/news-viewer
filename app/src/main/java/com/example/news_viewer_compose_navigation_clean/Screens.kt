package com.example.news_viewer_compose_navigation_clean

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.entity.searchResponseDomain.ResultSearchDomain
import com.example.news_viewer_compose_navigation_clean.presentation.NewsListUiState
import com.example.news_viewer_compose_navigation_clean.presentation.NewsResponseViewModel
import androidx.compose.ui.text.input.TextFieldValue


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
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    SearchView(state = textState)

    if (textState.value.text.isEmpty()) {
        state.fetchMoreData()
    } else {
        state.onWordValueChanged(textState.value.text)
        state.fetchTitleData()
    }

    state.onNumValueChanged(typeOfSearch)
    state.onWordValueChanged(aux)


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
        TopBar(
            title = "Business",
            buttonIcon = Icons.Filled.List,
            onButtonClicked = { openDrawer() })
        TabsBusiness(state = viewModel.registerState)
    }
}


@Composable
fun InitFootballScreen(viewModel: NewsResponseViewModel = hiltViewModel(), openDrawer: () -> Unit) {
    Column() {
        TopBar(
            title = "Football",
            buttonIcon = Icons.Filled.List,
            onButtonClicked = { openDrawer() })
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
        TopBar(
            title = "Politics",
            buttonIcon = Icons.Filled.List,
            onButtonClicked = { openDrawer() })
        TabsPolitics(state = viewModel.registerState)
    }
}


@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = colorResource(id = com.example.domain.R.color.colorPrimary),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}
