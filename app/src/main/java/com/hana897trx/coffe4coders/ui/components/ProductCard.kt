package com.hana897trx.coffe4coders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hana897trx.coffe4coders.R
import com.hana897trx.coffe4coders.ui.theme.Coffe4CodersTheme
import com.hana897trx.coffe4coders.ui.theme.PlatziBlue
import com.hana897trx.coffe4coders.ui.theme.PlatziGreen

enum class  CountryISO(val iso : String) {
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun getBackgroundImage() : Int {
        return when(this) {
            COL -> R.drawable.co
            BRA -> R.drawable.br
            CRI -> R.drawable.flagri
            NIC -> R.drawable.flagni
        }
    }

    fun getCountryFlag() : Int {
        return when(this) {
            COL -> R.drawable.flagco
            BRA -> R.drawable.flagbr
            CRI -> R.drawable.flagri
            NIC -> R.drawable.flagni
        }
    }

    fun getSurface() : Color {
        return when(this) {
            COL, NIC -> PlatziBlue
            BRA, CRI -> PlatziGreen
        }
    }
}

@Composable
fun ProductCard(name : String, summary : String, price : Double, currency : String, country : CountryISO) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { }
            .size(480.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Image(painter = painterResource(id = country.getBackgroundImage()), contentDescription = null)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = country.getSurface().copy(0.2F)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(name, style = MaterialTheme.typography.h4)
                Text(summary, style = MaterialTheme.typography.body1)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row (modifier = Modifier.fillMaxWidth()){
                        Image(
                            painter = painterResource(id = country.getCountryFlag()),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp, 32.dp)
                        )
                        Text("$ $price $currency",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            color = Color.White,
                            style = MaterialTheme.typography.h4
                        )
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
fun ProductCardPreview() {
    Coffe4CodersTheme {
        ProductCard(
            "Café de brasil",
            "Café de las montañas",
            35.0, "USD",
            CountryISO.BRA
        )
    }
}