package com.example.apptinkunakama.ui.navigation

sealed class Routes(val route: String) {
    object Login : Routes("Login")

    object Menu : Routes( "MenuScreen")
    object CurrentOrders : Routes("CurrentsOrders")
}
