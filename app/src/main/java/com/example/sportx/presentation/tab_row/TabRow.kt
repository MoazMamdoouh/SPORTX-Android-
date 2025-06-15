package com.example.sportx.presentation.tab_row

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sportx.presentation.fixtures.FixtureScreen
import com.example.sportx.presentation.home.HomeScreen
import com.example.sportx.presentation.leagues.LeaguesScreen
import com.example.sportx.presentation.routes.FixtureScreen
import com.example.sportx.presentation.routes.HomeScreen
import com.example.sportx.presentation.routes.LeaguesScreen

val tabRowItems = listOf(
    TabRowItems(
        "Sports",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home
    ),
    TabRowItems(
        "Favorite",
        selectedIcon = Icons.Filled.Favorite,
        unSelectedIcon = Icons.Outlined.FavoriteBorder
    )
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabRowFunction() {

    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) {
        var selectedTabIndex by remember {
            mutableIntStateOf(0)
        }

        val tabPages = rememberPagerState {
            tabRowItems.size
        }
        LaunchedEffect(selectedTabIndex) {
            tabPages.animateScrollToPage(selectedTabIndex)
        }
        LaunchedEffect(tabPages) {
            selectedTabIndex = tabPages.currentPage
        }
        Column {
            TabRow(selectedTabIndex) {
                tabRowItems.forEachIndexed { index, tabItem ->
                    Tab(index == selectedTabIndex, onClick = {
                        selectedTabIndex = index
                    },
                        text = {
                            Text(tabItem.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedTabIndex) {
                                    tabItem.selectedIcon
                                } else tabItem.unSelectedIcon, contentDescription = tabItem.title
                            )
                        }
                    )
                }
            }
            HorizontalPager(
                state = tabPages,
                modifier = Modifier.fillMaxWidth()
                    .weight(1f)
            ) { index ->
                Column {
                    if(index == 0 ) {
                        NavHost(navController, startDestination = HomeScreen) {
                            composable<HomeScreen> {
                                HomeScreen(navController)
                            }
                            composable<LeaguesScreen> {
                                val args = it.toRoute<LeaguesScreen>()
                                LeaguesScreen(args.sportType , navController)
                            }
                            composable<FixtureScreen> {
                                val args = it.toRoute<FixtureScreen>()
                                FixtureScreen(args.leagueId , args.sportType)
                            }
                        }
                    }else {
                        Text(text = tabRowItems[index].title)
                    }
                }
            }
        }
    }
}