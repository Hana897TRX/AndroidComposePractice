package com.hana897trx.coffe4coders.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hana897trx.coffe4coders.ui.components.*
import com.hana897trx.coffe4coders.ui.theme.Coffee4CodersTheme

@Composable
fun DetailScreen(navController: NavController, countryISO: CountryISO) {
    Scaffold(topBar = {
        CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            navController.navigateUp()
        } },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState(), true, )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ) {
                    Image(
                        painter = painterResource(id = countryISO.getBackgroundImage()),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    TitleText(title = "Café de colombia")
                    Text(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce semper augue tellus",
                        style = MaterialTheme.typography.caption
                    )
                    Spacer(modifier = Modifier.weight(0.2f))
                    BodyText(body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce semper augue tellus, et lacinia ante facilisis id. Fusce dignissim sapien sed odio placerat, sed euismod ipsum pulvinar.")
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("$ 35.0 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )
                        CustomButton(label = "Continuar") {
                            navController.navigate("checkout") {
                                launchSingleTop = true
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    Coffee4CodersTheme() {
        DetailScreen(navController = navController, CountryISO.BRA)
    }
}