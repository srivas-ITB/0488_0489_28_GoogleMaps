package com.example.app28_GoogleMaps.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerMenu(currentRoute: NavKey, backStack: NavBackStack<NavKey>, scope: CoroutineScope,
               drawerState: DrawerState
) {
    ModalDrawerSheet {
        Spacer(Modifier.height(24.dp))
        Text(text = "My awesome app", style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 8.dp)
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        drawerMenuItems.forEach { item ->
            // definició de cada ítem del DrawerMenu
            NavigationDrawerItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    backStack.clear()
                    backStack.add(item.route)
                    scope.launch { drawerState.close() }
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )

        }
    }
}
