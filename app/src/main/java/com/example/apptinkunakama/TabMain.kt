package com.example.apptinkunakama

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.launch
import androidx.compose.ui.input.nestedscroll.nestedScroll

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabMain() {
    val tabs = listOf(
        TabsItem.itemFood,
        TabsItem.itemDrink
    )
    val pagerState = rememberPagerState()

    Column(

    ) {
        Tabs(tabs, pagerState)
        Tabs_content(tabs, pagerState)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(tabs: List<TabsItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        //indicator = {tabPositions -> TabRowDefaults.Indicator(Modifier.tabIndicatorOffset( ))}
        /* , indicator = { tabPositions ->
             TabRowDefaults.Indicator(
                 Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
             )
         }*/
    )
    {
        tabs.forEachIndexed { index, tabsItem ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(tabsItem.title) },
                icon = {
                    Icon(
                        painter = painterResource(id = tabsItem.icon),
                        contentDescription = ""
                    )
                },
                unselectedContentColor = MaterialTheme.colorScheme.secondary
            )
        }

    }
}

//Pages
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs_content(tabs: List<TabsItem>, pagerState: PagerState) {
    HorizontalPager(
        pageCount = tabs.size,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        tabs[page].screen()
    }
}
