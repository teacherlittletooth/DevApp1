package com.qi.projectt.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.tooling.preview.Preview
import com.qi.projectt.composables.MyBottomBar
import com.qi.projectt.composables.MyTopBar
import com.qi.projectt.ui.theme.ProjectTTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyHome(
    modifier: Modifier = Modifier
) {
    val snackHost = remember { SnackbarHostState() }
    val snack = rememberCoroutineScope()

    Scaffold(
        content = {
            pad -> Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(pad)
                    .background(Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFBBE8AE),
                                Color(0xFFE4E591),
                                Color(0xFFE09D86),
                            )
                        )
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                repeat(50) { Text(text = "#$it") }
            }
        },
        topBar = { MyTopBar() },
        bottomBar = { MyBottomBar() },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color(0xFF3B9288),
                contentColor = Color(0xFF313430),
                onClick = {
                      snack.launch {
                          snackHost.showSnackbar(
                              "FEITO!",
                              withDismissAction = true,
                              duration = SnackbarDuration.Indefinite
                          )
                      }
                },
                content = {
                    Icon(
                        imageVector = Icons.Rounded.Send,
                        contentDescription = "Clique aqui"
                    )
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackHost)
        }
    )
}

////////////////////
@Preview
@Composable
fun HomePreview() {
    ProjectTTheme {
        MyHome()
    }
}