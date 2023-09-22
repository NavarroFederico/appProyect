package com.example.apptinkunakama.ui.navigation

sealed class Routes(val route: String) {
    object Login : Routes("Login Screen")

    object Home : Routes( "Home Screen")

    object Menu : Routes( "Menu Screen")
    object CurrentOrders : Routes("CurrentsOrders Screen")
    object SignUp : Routes("SignUp Screen")
    object ForgotPassword : Routes("ForgotPassword Screen")
}
