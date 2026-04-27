package com.example.app28_GoogleMaps.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.app28_GoogleMaps.ui.navigation.Route

sealed class DrawerMenuItem(val route: Route, val label: String, val icon: ImageVector) {
    data object Item1 : DrawerMenuItem(Route.Map, "Map", Icons.Default.Place)
    data object Item2 : DrawerMenuItem(Route.List, "Locations List", Icons.Default.Menu)
    data object Item3 : DrawerMenuItem(Route.Settings, "Settings", Icons.Default.Settings)
}
val drawerMenuItems = listOf(DrawerMenuItem.Item1, DrawerMenuItem.Item2, DrawerMenuItem.Item3)
