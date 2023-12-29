package com.example.passwordmanager.ScreenNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreen (
    val title:String,
    val selected: ImageVector,
    val unSelected: ImageVector,
){
    object Home: BottomNavScreen( title = "HOME",
        selected =  Icons.Filled.Home,
        unSelected = Icons.Outlined.Home,
        )
    object Analysis: BottomNavScreen( title = "ANALYSIS",
        selected =  Icons.Filled.Home,
        unSelected = Icons.Outlined.Home,
    )
    object Search: BottomNavScreen( title = "SEARCH",
        selected =  Icons.Filled.Search,
        unSelected = Icons.Outlined.Search,
    )
    object Setting: BottomNavScreen(title = "SETTING",
        selected =  Icons.Filled.Settings,
        unSelected = Icons.Outlined.Settings,
    )

}
