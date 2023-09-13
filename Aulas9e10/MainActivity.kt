package com.qi.aula9noite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qi.aula9noite.ui.theme.Aula9NoiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula9NoiteTheme {

            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier
) {
    var screen by remember {
        mutableStateOf(0)
    }

    when(screen) {
        0 -> Greeting(login = { screen = 1 })
        1 -> HomePage()
    }
}


@Composable
fun HomePage(
    modifier: Modifier = Modifier
) {
    Text(text = stringResource(id = R.string.home_page))
}


@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    login: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.welcome),
            style = MaterialTheme.typography.titleLarge
        )

        MyTextField(icon = Icons.Outlined.AccountCircle)

        MyTextField(
            isPassword = true,
            icon = Icons.Outlined.Lock,
            keyboard = KeyboardType.Password
        )

        Divider(
            thickness = 2.dp,
            modifier = modifier.padding(40.dp)
        )

        Button(
            onClick = login
        ) {
            Text(
                text = stringResource(id = R.string.btn_login),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    icon: ImageVector,
    keyboard: KeyboardType = KeyboardType.Text
) {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var showPass by remember {
        mutableStateOf(false)
    }

    Surface(
        color = MaterialTheme.colorScheme.onTertiary,
        shape = MaterialTheme.shapes.large,
        modifier = modifier.padding(10.dp)
    ) {
        Row {
            TextField(
                value = text,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboard
                ),
                leadingIcon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    if(isPassword) {
                        Icon(
                            imageVector =
                            if (showPass) Icons.Outlined.Favorite
                            else Icons.Outlined.FavoriteBorder,
                            contentDescription = null,
                            modifier = modifier.clickable { showPass = !showPass }
                        )
                    }
                },
                visualTransformation =
                    if(!isPassword || showPass) VisualTransformation.None
                    else PasswordVisualTransformation('?')
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun GreetingPreview() {
    Aula9NoiteTheme {
        MyApp()
    }
}
