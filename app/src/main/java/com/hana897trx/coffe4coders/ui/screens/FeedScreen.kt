package com.hana897trx.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hana897trx.coffe4coders.ui.components.BodyText
import com.hana897trx.coffe4coders.ui.components.CountryISO
import com.hana897trx.coffe4coders.ui.components.ProductCard
import com.hana897trx.coffe4coders.ui.components.TitleText
import com.hana897trx.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun FeedScreen(navController: NavController) {
    val list = listOf<CountryISO>(
        CountryISO.COL,
        CountryISO.CRI,
        CountryISO.NIC,
        CountryISO.BRA
    )

    Coffe4CodersTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Column(
                        Modifier.padding(8.dp)
                    ) {
                        TitleText(title = "Bievenido")
                        BodyText(body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque lobortis massa sit amet justo porta feugiat. Vestibulum et egestas leo, vitae aliquet arcu. Nam tristique purus eu vulputate egestas. Aenean sagittis lorem quis hendrerit tristique.")
                    }
                }
                items(list) { country ->
                    ProductCard(
                        name = "Café de Colombia",
                        summary = "Café de las montañas",
                        price = 35.0,
                        currency = "USD",
                        country = country
                    ) {
                        navController.navigate("detail") {
                            launchSingleTop = true
                        }
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController)
}