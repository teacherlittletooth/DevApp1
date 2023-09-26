package com.qi.instagreent.composables

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qi.instagreent.ui.theme.InstagreenTTheme

@Composable
fun MyNavigation(
    modifier: Modifier = Modifier,
    item: Int,
    onChangeItem: (Int) -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = item == 0,
            onClick = { onChangeItem(0) },
            icon = { Text(text = "Perfil") }
        )
        NavigationBarItem(
            selected = item == 1,
            onClick = { onChangeItem(1) },
            icon = { Text(text = "Home") }
        )
        NavigationBarItem(
            selected = item == 2,
            onClick = { onChangeItem(2) },
            icon = {
                Image(
                    imageVector = Icons.Default.Build,
                    contentDescription = null
                )
            }
        )
    }
}


@Composable
fun MyNavigationState(
    modifier: Modifier = Modifier
) {
    var controlItem by remember {
        mutableStateOf(0)
    }

    MyNavigation(
        item = controlItem,
        onChangeItem = { newValue -> controlItem = newValue }
    )
}


/////////////////////////////////////////////
@Preview
@Composable
fun NavPreview() {
    InstagreenTTheme {
        MyNavigationState()
    }
}