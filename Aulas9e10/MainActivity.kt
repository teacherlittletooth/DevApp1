package com.qi.aula9manha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = stringResource(id = R.string.text_screen1))

        MyTextField(
            isPassword = false,
            imageVector = Icons.Rounded.Person,
            text = R.string.tf2,
            keyboardType = KeyboardType.Text
        )

        MyTextField(
            isPassword = true,
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

////////////////////////////Criando compomente "TextField" reutilizável
@Composable
fun MyTextField(
    isPassword: Boolean,
    imageVector: ImageVector,
    @StringRes text: Int,
    keyboardType: KeyboardType,
    modifier: Modifier = Modifier
) {
    var showPass by remember {
        mutableStateOf(false)
    }

    var textField by remember {
        mutableStateOf(TextFieldValue(""))
    }

    TextField(
        value = textField,
        onValueChange = { textField = it },
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                modifier = if(isPassword) modifier.clickable { showPass = !showPass } else modifier
            )
        },
        placeholder = {
            Text(text = stringResource(id = text))
        },
        visualTransformation = if (showPass || !isPassword) VisualTransformation.None else PasswordVisualTransformation('X'),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
    )
}
///////////////////////////////////////////////////////////////////////////

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun DefaultPreview() {
    Aula9ManhaTheme {
        //Greeting()
        //HomePage()
        MyApp()
    }
}
