package com.yasserakbbach.borutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.yasserakbbach.borutoapp.navigation.SetupBorutoNavGraph
import com.yasserakbbach.borutoapp.ui.theme.BorutoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoAppTheme {
                val navController = rememberNavController()
                SetupBorutoNavGraph(navController = navController)
            }
        }
    }
}