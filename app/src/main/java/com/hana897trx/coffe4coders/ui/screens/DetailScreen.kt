package com.hana897trx.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hana897trx.coffe4coders.ui.components.CountryISO
import com.hana897trx.coffe4coders.ui.components.CustomAppBar

@Composable
fun DetailScreen(navController: NavController, countryISO: CountryISO) {
    Scaffold(topBar = {
        CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            navController.navigateUp()
        } },
        content = {
            Column() {
                Text("Soy un producto de : ${countryISO.iso}", style = MaterialTheme.typography.body2)
                Button(onClick = { navController.navigateUp() }) {
                    Text(text = "Volver")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    DetailScreen(navController = navController, CountryISO.BRA)
}