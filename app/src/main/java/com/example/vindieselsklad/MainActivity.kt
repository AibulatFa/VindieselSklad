package com.example.vindieselsklad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.rememberNavController
import com.example.vindieselsklad.ui.theme.VindieselSkladTheme
import com.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            VindieselSkladTheme {}
            Navigation(navController = navController)
        }
    }
}

