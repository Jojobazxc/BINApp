package com.example.presentation.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.presentation.ScreenRoutes
import com.example.presentation.ui.theme.ButtonsColor
import com.example.presentation.ui.theme.MainFontFamily
import com.example.presentation.ui.theme.TextColor

@Composable
fun AppNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem("Информация", Icons.Default.Info, ScreenRoutes.BIN_INFO_SCREEN),
        NavigationItem("История", Icons.Default.Menu, ScreenRoutes.HISTORY_SCREEN)
    )
    NavigationBar(
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = {
                    Text(
                        text = item.name,
                        fontSize = 14.sp,
                        fontFamily = MainFontFamily,
                        fontWeight = FontWeight.Bold,
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ButtonsColor,
                    selectedTextColor = ButtonsColor,
                    unselectedTextColor = TextColor,
                    unselectedIconColor = TextColor
                )
            )
        }
    }
}

data class NavigationItem(
    val name: String,
    val icon: ImageVector,
    val route: String
)