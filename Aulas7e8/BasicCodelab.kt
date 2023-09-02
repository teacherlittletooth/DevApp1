package com.donini.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.donini.myapplication.ui.theme.BasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

//Pegar frases aleatórias
fun takePhrase(option: Int = 0) : String {
    var phrase = ""
    when(option) {
        0 -> phrase = "Mussum Ipsum, cacilds vidis litro abertis.  Mé faiz elementum girarzis, nisi eros vermeio. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! In elementis mé pra quem é amistosis quis leo. Atirei o pau no gatis, per gatis num morreus."
        1 -> phrase = "Per aumento de cachacis, eu reclamis. Cevadis im ampola pa arma uma pindureta. Aenean aliquam molestie leo, vitae iaculis nisl. Quem manda na minha terra sou euzis!"
        2 -> phrase = "Diuretics paradis num copo é motivis de denguis. Viva Forevis aptent taciti sociosqu ad litora torquent. Aenean aliquam molestie leo, vitae iaculis nisl. Suco de cevadiss deixa as pessoas mais interessantis."
        3 -> phrase = "Aenean aliquam molestie leo, vitae iaculis nisl. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis. Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus. Quem num gosta di mé, boa gentis num é."
        4 -> phrase = "Cevadis im ampola pa arma uma pindureta. Praesent vel viverra nisi. Mauris aliquet nunc non turpis scelerisque, eget. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi."
        else -> phrase = "Acabaram as mensagens."
    }
    return phrase
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnBoarding by rememberSaveable {
        mutableStateOf(true)
    }

    if(shouldShowOnBoarding) {
        OnBoardingScreen(onContinueClicked = {shouldShowOnBoarding = false})
    } else {
        Greetings()
    }

}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(10) {"$it"}
) {
    LazyColumn(
        modifier = modifier.padding(vertical = 4.dp),
    ) {
        items(names) {
            name -> Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    val extraPadding by animateDpAsState(
        label = "Greeting animation",
        targetValue = if(expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 6.dp, horizontal = 6.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "$name")
                if(expanded) {
                    Text(
                        text = takePhrase(name.toInt()),
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                }
            }
//            ElevatedButton(
//                onClick = { expanded = !expanded }
//            ) {
//                Text(if(expanded) "Show less" else "Show more")
//            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if(expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if(expanded) {
                        stringResource(id = R.string.show_less)
                    } else {
                        stringResource(id = R.string.show_more)
                    }
                )
            }
        }
    }
}

@Composable
fun OnBoardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320
)
@Composable
fun MyAppPreview() {
    BasicCodelabTheme {
        MyApp()
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320
)
@Composable
fun OnBoardingPreview() {
    BasicCodelabTheme {
        OnBoardingScreen(onContinueClicked = {})
    }
}

@Preview(
    showBackground = true,
    name = "Light mode",
    widthDp = 320
)
@Preview(
    showBackground = true,
    name = "Dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 320
)
@Composable
fun GreetingPreview() {
    BasicCodelabTheme {
        Greeting("Android")
    }
}
