package com.qi.finalproject.composables

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFFE0C832),
            titleContentColor = Color(0xFF156605)
        ),
        title = {
            Text(
                text = "APLICATIVO",
                fontWeight = FontWeight(900)
            )
        }
    )
}

/////////////////////////////
@Preview
@Composable
fun TopBarPreview() {
    MyTopBar()
}