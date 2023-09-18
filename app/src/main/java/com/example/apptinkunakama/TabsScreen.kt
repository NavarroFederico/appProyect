package com.example.apptinkunakama

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun Foods() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            "Foods",
            style = MaterialTheme.typography.headlineLarge
        )

        LazyColumn(
              // contentPadding = innerPadding,
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
    }


}

@Preview(showSystemUi = true)
@Composable
fun Drinks() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),

        ) {
        Text(
            "Drinks",
            style = MaterialTheme.typography.headlineLarge,
        )
    }


}

