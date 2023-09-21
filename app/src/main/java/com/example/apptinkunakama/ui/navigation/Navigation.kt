package com.example.apptinkunakama.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apptinkunakama.ui.screens.Screen
import com.example.apptinkunakama.ui.screens.login.Login
import com.example.apptinkunakama.ui.screens.menu.MenuScreen
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent

@Composable
fun Navigation(
    analytics: FirebaseAnalytics,
    navController: NavHostController = rememberNavController()
) {
    Screen {
        NavHost(
            navController = navController,
            startDestination = Routes.Login.route
        ) {
            composable(Routes.Login.route) {
                Login(
                    analytics = analytics,
                    navigateToMenu = {
                        navController.navigate(Routes.CurrentOrders.route)
                    }
                )
            }
            composable(Routes.CurrentOrders.route) {
                MenuScreen(
                    analytics = analytics
                )

            }

        }
    }
}

@Composable
fun TrackScreen(name: String, analytics: FirebaseAnalytics) {
    DisposableEffect(Unit) {
        onDispose {
            analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                param(FirebaseAnalytics.Param.SCREEN_NAME, name)
            }
        }
    }
}
