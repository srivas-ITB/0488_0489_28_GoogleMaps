package com.example.app28_GoogleMaps.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
   Column(modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally)
   {
    Text("Aquesta és la SettingsScreen",
        modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 20.sp)
   }


}