package com.example.apptinkunakama

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

enum class OrdersPage(
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int
) {
    FOODS(R.string.foods_title, R.drawable.ic_food_24),
    DRINKS(R.string.drinks_title, R.drawable.ic_drinks_24)

}

@Preview
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun OrderScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Tinkunama",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.displaySmall
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        /*content = { innerPadding ->

            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val list = (0..75).map { it.toString() }
                items(count = list.size) {
                    Text(
                        text = list[it],
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }*/
    ){
        OrderPagerScreen(
            pagerState =pagerState,
            modifier = Modifier.padding(it))
    }
}@Preview
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun OrderScreen2(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Tinkunama",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.displaySmall
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        /*content = { innerPadding ->

            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val list = (0..75).map { it.toString() }
                items(count = list.size) {
                    Text(
                        text = list[it],
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }*/
    ){
        OrderPagerScreen(
            pagerState =pagerState,
            modifier = Modifier.padding(it))
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrderPagerScreen(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    pages: Array<OrdersPage> = OrdersPage.values()
) {
    Column(modifier) {
        val coroutineScope = rememberCoroutineScope()

        // Tab Row
        TabRow(selectedTabIndex = pagerState.currentPage
        ) {
            pages.forEachIndexed { index,page ->
                val title = stringResource (id = page.titleResId)
                Tab (
                    selected = pagerState.currentPage == index ,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = { Text(text = title)},
                    icon = {
                        Icon(
                            painter = painterResource(id = page.drawableResId),
                            contentDescription = title
                        )
                    },
                    unselectedContentColor = MaterialTheme.colorScheme.secondary

                )
            }
        }

        //pages
        HorizontalPager(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            pageCount = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top

        ){index ->
            when (pages[index]) {
                OrdersPage.FOODS->{
                    Foods()
                }
                OrdersPage.DRINKS->{
                    Drinks()
                }
            }

        }
    }
}

