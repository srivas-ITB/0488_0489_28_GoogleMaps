package com.example.app28_GoogleMaps.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


sealed class Route: NavKey {
    @Serializable
    data object Map: Route()
    @Serializable
    data object List: Route()
    @Serializable
    data object Settings: Route()
}
