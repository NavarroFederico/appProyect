package com.example.apptinkunakama.ui.screens.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.apptinkunakama.ui.navigation.Routes
import com.example.apptinkunakama.utils.AnalyticsManager

@Composable
fun MenuScreen(analytics: AnalyticsManager, navigation: NavController) {

    analytics.LogScreenView(screenName = Routes.Menu.route)

    val navigation = rememberNavController()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Orders", fontSize = 40.sp)
    }

}