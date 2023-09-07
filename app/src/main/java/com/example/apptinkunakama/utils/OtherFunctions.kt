package com.example.apptinkunakama.utils

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun BotonCrash() {

    Button(onClick = { throw RuntimeException("Test Crash") }) {
        Text(text = "Throw Exception")
    }

}