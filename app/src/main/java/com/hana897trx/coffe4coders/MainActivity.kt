package com.hana897trx.coffe4coders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hana897trx.coffe4coders.ui.components.CountryISO
import com.hana897trx.coffe4coders.ui.screens.DetailScreen
import com.hana897trx.coffe4coders.ui.screens.FeedScreen
import com.hana897trx.coffe4coders.ui.theme.Coffee4CodersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost()
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    Coffee4CodersTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feed") {
                composable(route = "feed") {
                    FeedScreen(navController)
                }
                composable(route = "detail/{countryIso}") { backStackEnty ->
                    val countryIsoString = backStackEnty.arguments?.getString("countryIso") ?: "COL"
                    val countryIso = CountryISO.valueOf(countryIsoString)
                    DetailScreen(navController, countryIso)
                }
            }
        }
    }
}