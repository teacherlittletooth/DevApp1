package com.qi.finalproject.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomBar(
    modifier: Modifier = Modifier,
    textValue: TextFieldValue,
    onTextChange: (TextFieldValue) -> Unit
) {
    NavigationBar(
        containerColor = Color(0xFFE0C832),
        contentColor = Color(0xFF156605),
        content = {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFF),
                    unfocusedLeadingIconColor = Color(0xFF156605),
                    focusedLeadingIconColor = Color(0xFF0063C6),
                    textColor = Color(0xFF000000),
                    placeholderColor = Color(0xFF292929),
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                value = textValue,
                onValueChange = onTextChange,
                placeholder = { Text(text = "Pesquisar") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Ícone de pesquisa"
                    )
                }
            )
        }
    )
}

@Composable
fun MyBottomBarState(
    modifier: Modifier = Modifier
) {
    var txt by remember {
        mutableStateOf(TextFieldValue(""))
    }

    MyBottomBar(
        textValue = txt,
        onTextChange = { newText -> txt = newText}
    )
}

@Preview
@Composable
fun BottomBarPreview() {
    MyBottomBarState()
}