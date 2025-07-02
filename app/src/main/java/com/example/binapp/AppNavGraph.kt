package com.example.binapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.ScreenRoutes
import com.example.presentation.screens.BinInfoScreen
import com.example.presentation.screens.HistoryScreen
import com.example.presentation.utils.AppNavigationBar

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            AppNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenRoutes.BIN_INFO_SCREEN,
            Modifier.padding(innerPadding)
        ) {
            composable(ScreenRoutes.BIN_INFO_SCREEN) { BinInfoScreen() }
            composable(ScreenRoutes.HISTORY_SCREEN) { HistoryScreen() }
        }
    }
}


