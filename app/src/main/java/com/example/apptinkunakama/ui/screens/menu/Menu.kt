package com.example.apptinkunakama.ui.screens.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.apptinkunakama.ui.navigation.TrackScreen
import com.google.firebase.analytics.FirebaseAnalytics

@Composable
fun MenuScreen(analytics: FirebaseAnalytics) {
    TrackScreen(name = "Ingreso a MenuScreen", analytics = analytics)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Orders", fontSize = 40.sp)
    }

}