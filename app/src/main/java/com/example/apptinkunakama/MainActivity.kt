package com.example.apptinkunakama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.apptinkunakama.ui.navigation.Navigation
import com.example.apptinkunakama.ui.theme.AppTinkunakamaTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            AppTinkunakamaTheme {
                Navigation(this)
            }
        }
    }
}


