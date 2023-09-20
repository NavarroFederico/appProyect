package com.example.apptinkunakama.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apptinkunakama.ui.screens.Screen
import com.example.apptinkunakama.ui.screens.login.Login
import com.example.apptinkunakama.ui.screens.menu.MenuScreen
import com.example.apptinkunakama.ui.screens.orders.CurrentsOrders

@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {
    Screen {
        NavHost(
            navController = navController,
            startDestination = Routes.Login.route
        ) {
            composable(Routes.Login.route) {
                Login(
                    navigateToMenu = {
                        navController.navigate(Routes.CurrentOrders.route)
                    }
                )
            }
            composable(Routes.CurrentOrders.route) {
                MenuScreen()

            }

        }
    }
}