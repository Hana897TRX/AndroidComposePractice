package com.hana897trx.coffe4coders.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.hana897trx.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun BodyText(body : String) {
    Text(
        body,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify
    )
}

@Preview(
    showBackground = true
)
@Composable
fun BodyTextPreview() {
    Coffe4CodersTheme {
        BodyText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque lobortis massa sit amet justo porta feugiat. Vestibulum et egestas leo, vitae aliquet arcu. Nam tristique purus eu vulputate egestas. Aenean sagittis lorem quis hendrerit tristique.")
    }
}