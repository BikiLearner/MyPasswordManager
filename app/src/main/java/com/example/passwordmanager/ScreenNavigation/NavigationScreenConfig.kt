package com.example.passwordmanager.ScreenNavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.passwordmanager.allScreensUi.AllScreenTitle
import com.example.passwordmanager.allScreensUi.AnalysisScreen
import com.example.passwordmanager.allScreensUi.HomeScreen
import com.example.passwordmanager.allScreensUi.PasswordGenerationScreen

@Composable
fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavScreen.Home.title ) {
        composable(BottomNavScreen.Home.title) {
            HomeScreen(navController = navController)
        }
        composable(BottomNavScreen.Analysis.title) {
            AnalysisScreen()
        }
        composable(AllScreenTitle.PasswordGenerationScreen.name) {
            PasswordGenerationScreen()
        }
    }
}
@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString("KEY_ROUTE")
}