package com.example.news_viewer_compose_navigation_clean

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.news_viewer_compose_navigation_clean.ui.theme.NavigationDrawerTheme


sealed class DrawerScreens(val title: String, val route: String) {
    object Technology : DrawerScreens("Technology", "tech")
    object Business : DrawerScreens("Business", "business")
    object Football : DrawerScreens("Football", "football")
    object Music : DrawerScreens("Music", "music")
    object Politics : DrawerScreens("Politics", "politics")
}

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_baseline_android),
            contentDescription = "App icon"
        )
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.clickable {
                    onDestinationClicked(screen.route)
                }
            )
        }
    }
}

private val screens = listOf(
    DrawerScreens.Technology,
    DrawerScreens.Business,
    DrawerScreens.Football,
    DrawerScreens.Music,
    DrawerScreens.Politics
)

@Preview
@Composable
fun DrawerPreview() {
    NavigationDrawerTheme {

    }
}
