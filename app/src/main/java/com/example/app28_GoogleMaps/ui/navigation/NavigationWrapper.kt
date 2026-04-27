package com.example.app28_GoogleMaps.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.app28_GoogleMaps.ui.components.DrawerMenu
import com.example.app28_GoogleMaps.ui.components.drawerMenuItems
import com.example.app28_GoogleMaps.ui.screens.list.ListScreen
import com.example.app28_GoogleMaps.ui.screens.map.MapScreen
import com.example.app28_GoogleMaps.ui.screens.settings.SettingsScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Route.Map)
    val currentRoute by remember { derivedStateOf { backStack.last() } }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(drawerState = drawerState,
        //Afegir això per desactivar el gesture (genera conflicte amb GoogleMaps)
        gesturesEnabled = drawerState.isOpen,
        drawerContent = { DrawerMenu(currentRoute, backStack, scope, drawerState) }
    ) {
        // definició de l'Scaffold
        Scaffold(
            topBar = {
                TopAppBar( title = {
                    val title = drawerMenuItems.first { it.route == currentRoute }.label
                    Text(title)},
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Open menu")
                        }
                    }
                )
            }
        ) { innerPadding -> // NavDisplay
            NavDisplay(
                backStack = backStack,
                modifier  = Modifier.padding(innerPadding),
                entryProvider = entryProvider {
                    entry<Route.Map> { MapScreen() }
                    entry<Route.List> { ListScreen() }
                    entry<Route.Settings> { SettingsScreen() }
                }
            )

        }

    }
}
