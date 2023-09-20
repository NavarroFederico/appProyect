package com.example.apptinkunakama.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.apptinkunakama.ui.theme.AppTinkunakamaTheme

@Composable
fun Screen(content: @Composable () -> Unit) {
    AppTinkunakamaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}