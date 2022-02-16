package com.hana897trx.coffe4coders.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.hana897trx.coffe4coders.ui.theme.Coffee4CodersTheme

@Composable
fun CustomAppBar(
    title: String = "",
    navigationIcon: ImageVector? = null,
    navigationAction: () -> Unit
) {
    if(navigationAction != null && navigationIcon != null) {
        TopAppBar(
            title = {Text(title)},
            navigationIcon = {
              IconButton(onClick = { navigationAction() }) {
                  Icon(navigationIcon, contentDescription = null)
              }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    } else {
        TopAppBar(
            title = {Text(title)},
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CustomAppBarPreview() {
    Coffee4CodersTheme() {
        CustomAppBar("Coffe 4 Coders") {

        }
    }
}