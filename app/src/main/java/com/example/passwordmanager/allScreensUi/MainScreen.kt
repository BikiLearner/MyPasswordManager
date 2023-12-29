package com.example.passwordmanager.allScreensUi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.passwordmanager.ScreenNavigation.BottomNavScreen
import com.example.passwordmanager.ScreenNavigation.MainScreenNavigationConfigurations
import com.example.passwordmanager.ScreenChangeViewModel
import com.example.passwordmanager.ScreenNavigation.currentRoute


@Composable
fun MainScreen(navController: NavHostController){
    val bottomNavigationItems = listOf(
        BottomNavScreen.Home,
        BottomNavScreen.Analysis,
        BottomNavScreen.Search,
        BottomNavScreen.Setting
    )
    val viewModel=ScreenChangeViewModel()
    Scaffold(
        topBar = {
            TopAppBar(onCLickAdd = {
                navController.navigate(
                    AllScreenTitle.
                PasswordGenerationScreen.name)
            },viewModel.currentScreenTitle.value)

        },
        bottomBar = {
            BottomNavBarComposable(navController =navController ,
                items =bottomNavigationItems)

        }
    ) {scaffoldPadding->
        Surface(modifier = Modifier.padding(scaffoldPadding)) {
            MainScreenNavigationConfigurations(navController =
            navController)

        }

    }
}

@Composable
fun BottomNavBarComposable(navController: NavHostController,
    items:List<BottomNavScreen>) {
    NavigationBar {
        val currentRoute = currentRoute(navController =
        navController)
        items.forEach {screen->
            NavigationBarItem(
                selected = currentRoute == screen.title,
                onClick = {
                    if (currentRoute != screen.title) {
                        navController.navigate(screen.title)
                    } },
                icon = {
                    Icon(imageVector =
                    if (currentRoute == screen.title){
                        screen.selected
                    }
                    else {
                        screen.unSelected
                         },
                        contentDescription ="Icon")
                })
        }

    }
}
