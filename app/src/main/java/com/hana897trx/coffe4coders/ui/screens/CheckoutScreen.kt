package com.hana897trx.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hana897trx.coffe4coders.ui.components.CustomTextField
import com.hana897trx.coffe4coders.ui.components.DropdownTextField
import com.hana897trx.coffe4coders.ui.theme.Coffee4CodersTheme

@Composable
fun CheckoutScreen() {
    var name by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    val cities = listOf(
        "Mexico City, Mexico",
        "The Habana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panama"
    )
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        CustomTextField(
            value = name,
            placeholder = "Nombre",
            onValueChange = { name = it }
        )
        DropdownTextField(
            suggestions = cities,
            value = city,
            placeholder = "Ciudad"
        ) {
            city = it
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    Coffee4CodersTheme() {
        CheckoutScreen()
    }
}