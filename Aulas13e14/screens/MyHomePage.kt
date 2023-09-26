package com.qi.instagreent.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qi.instagreent.composables.MyListCard
import com.qi.instagreent.composables.MyNavigationState
import com.qi.instagreent.model.listCard
import com.qi.instagreent.ui.theme.InstagreenTTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyHomePage(
    modifier: Modifier = Modifier
) {
    Scaffold(
        floatingActionButton = {
             FloatingActionButton(
                 onClick = { /*TODO*/ }
             ) {
                 Icon(
                     imageVector = Icons.Default.Add,
                     contentDescription = null
                 )
             }
        },
        bottomBar = { MyNavigationState() },
        content = {
            myVar -> MyListCard(
                        list = listCard,
                        modifier = modifier.padding(myVar)
                    )
        }
    )
}

/////////////////////
@Preview
@Composable
fun HomePreview() {
    InstagreenTTheme {
        MyHomePage()
    }
}