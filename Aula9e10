package com.qi.aula9manha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.*
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.qi.aula9manha.ui.theme.Aula9ManhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula9ManhaTheme {
                MyApp()
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
        0 -> Greeting(screen = {screen = 1})
        1 -> HomePage()
    }
}

@Composable
fun HomePage(
    modifier: Modifier = Modifier
) {
    Column() {
        Text(text = "Home Page")
    }
}

@Composable
fun Greeting(
    screen: () -> Unit,
    modifier: Modifier = Modifier
) {
    var userName by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var userPass by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = stringResource(id = R.string.text_screen1))

        TextField(
            value = userName,
            onValueChange = { userName = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = null
                )
            },
            placeholder = {
                Text(text = stringResource(id = R.string.tf1))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )

        MyTextField(
            value = userPass,
            imageVector = Icons.Rounded.Lock,
            text = R.string.tf2,
            keyboardType = KeyboardType.Password
        )

        Button(
            onClick = screen
        ) {
            Text(text = stringResource(id = R.string.btn1))
        }
    }
}



@Composable
fun MyTextField(
    value: TextFieldValue,
    imageVector: ImageVector,
    @StringRes text: Int,
    keyboardType: KeyboardType
) {
    TextField(
        value = value,
        onValueChange = { value },
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        },
        placeholder = {
            Text(text = stringResource(id = text))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun DefaultPreview() {
    Aula9ManhaTheme {
        //Greeting()
        //HomePage()
        MyApp()
    }
}
