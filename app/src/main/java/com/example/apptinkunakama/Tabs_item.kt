package com.example.apptinkunakama

import androidx.compose.runtime.Composable

typealias MyFuntion = @Composable () -> Unit

sealed class TabsItem(
    var icon: Int,
    var title: String,
    var screen: MyFuntion
) {
    object itemFood : TabsItem(R.drawable.baseline_restaurant_24, "FOODS", { Foods() })

    object itemDrink : TabsItem(R.drawable.baseline_liquor_24, "DRINKS", { Drinks() })
}
