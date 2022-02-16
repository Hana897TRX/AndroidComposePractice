package com.hana897trx.coffe4coders.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.hana897trx.coffe4coders.ui.components.CustomTextField

@Composable
fun CheckoutScreen() {
    val name = remember { mutableStateOf("") }
    CustomTextField(
        value = name.value,
        placeholder = "Nombre",
        onValueChange = { name.value = it }
    )
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen()
}