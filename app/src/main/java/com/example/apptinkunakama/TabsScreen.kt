package com.example.apptinkunakama

import android.graphics.Paint.Style
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun Foods() {
    Column(
        modifier = Modifier
            .fillMaxWidth().wrapContentSize(Alignment.Center)
    ) {
        Text(
            "Foods",
            style = MaterialTheme.typography.headlineLarge
        )
    }


}
@Preview(showSystemUi = true)
@Composable
fun Drinks() {
    Column(
        modifier = Modifier
            .fillMaxWidth().wrapContentSize(Alignment.Center),

    ) {
        Text(
            "Drinks",
            style = MaterialTheme.typography.headlineLarge,
        )
    }


}

