package com.qi.projectt.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.qi.projectt.ui.theme.ProjectTTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    modifier: Modifier = Modifier
) {
    SmallTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFF3B9288),
            actionIconContentColor = Color(0xFF313430),
            navigationIconContentColor = Color(0xFF313430),
            titleContentColor = Color(0xFF313430)
        ),
        title = {
            Text(
                text = "Aplicativo",
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
             IconButton(
                 onClick = {},
                 content = {
                     Icon(
                         imageVector = Icons.Outlined.Menu,
                         contentDescription = "Menu"
                     )
                 }
             )//IconButton
        },
        actions = {
            IconButton(
                onClick = {},
                content = {
                    Icon(
                        imageVector = Icons.Outlined.AddCircle,
                        contentDescription = "Menu"
                    )
                }
            )//IconButton
            IconButton(
                onClick = {},
                content = {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "Menu"
                    )
                }
            )//IconButton
        }
    )
}

////////////////////////////////
@Preview
@Composable
fun TopBarPreview() {
    ProjectTTheme {
        MyTopBar()
    }
}