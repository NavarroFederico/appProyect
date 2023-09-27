package com.example.apptinkunakama.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apptinkunakama.ui.screens.HomeScreen
import com.example.apptinkunakama.ui.screens.Screen
import com.example.apptinkunakama.ui.screens.auth.ForgotPasswordScreen
import com.example.apptinkunakama.ui.screens.auth.LoginScreen
import com.example.apptinkunakama.ui.screens.auth.SignUpScreen
import com.example.apptinkunakama.ui.screens.menu.MenuScreen
import com.example.apptinkunakama.utils.AnalyticsManager
import com.example.apptinkunakama.utils.AuthManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.auth.FirebaseUser

@Composable
fun Navigation(
    context: Context,
    navController: NavHostController = rememberNavController()
) {
    var analytics: AnalyticsManager = AnalyticsManager(context)
    val authManager: AuthManager = AuthManager()

    val user: FirebaseUser? = authManager.getCurrentUser()

    Screen {
        NavHost(
            navController = navController,
            startDestination = if (user == null )Routes.Login.route else
            Routes.Home.route
        ) {
            composable(Routes.Login.route) {
                LoginScreen(
                    analytics = analytics,
                    auth = authManager,
                    navigation = navController
                )
            }
            composable(Routes.Home.route) {
                HomeScreen(
                    analytics = analytics,
                    auth = authManager,
                    navigation = navController)
            }
            composable(Routes.SignUp.route) {
                SignUpScreen(
                    analytics = analytics,
                    auth = authManager,
                    navigation = navController
                )
            }
            composable(Routes.ForgotPassword.route) {
                ForgotPasswordScreen(
                    analytics = analytics,
                    navigation = navController
                )
            }
            composable(Routes.Menu.route) {
                MenuScreen(
                    analytics = analytics,
                    navigation =navController
                )

            }

        }
    }
}

