package com.donini.composetutorialn //Cuidar, porque o nome do projeto dará o nome à classe que implementa o Material Design

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.donini.composetutorialn.ui.theme.ComposeTutorialNTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialNTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Conversation(listMessage)
                }
            }
        }
    }
} //Fim da Activity

data class Message(val avatar: Int, val author: String, val body: String)

var listMessage = mutableListOf(
    Message(
        R.drawable.stevejobs,
        "Steve Jobs",
        "A tecnologia move o mundo\niMac é melhor que Positivo."
    ),
    Message(
        R.drawable.chaves,
        "Chaves",
        "Ninguém tem paciência comigo!\nA carne de burro não é transparente."
    ),
    Message(
        R.drawable.goku,
        "Goku",
        "Kame, hame...\nHÁÁÁÁÁ!."
    ),
    Message(
        R.drawable.scooby,
        "Scooby Doo",
        "Sa-sa-sa-Salsicha...\nScooby doobi dooo!."
    ),
    Message(
        R.drawable.seya,
        "Seya de Pégasus",
        "Meteóro de Pégasus!!!\nSaoriiiii!."
    ),
    Message(
        R.drawable.silviosantos,
        "Sílvio Santos",
        "Quem quer dinheiro!\nVai pra lá, vem pra cá!\n Maaaa ooiieee!"
    ),
)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn{
        items(messages) {
            msg -> MessageCard(msg)
        }
    }
}

@Composable
fun MessageCard(msg: Message) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier.padding(15.dp)) {
        Image(
            painter = painterResource(id = msg.avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.primaryVariant, CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.primaryVariant
            )

            Spacer(modifier = Modifier.height(2.dp))

            Surface(
                elevation = 5.dp,
                color = if(isExpanded) MaterialTheme.colors.primarySurface
                        else MaterialTheme.colors.background,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(all = 10.dp),
                    maxLines = if(isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

@Preview(name = "Light mode")
@Preview(
    showBackground = true,
    name = "Dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MessageCardPreview() {
    ComposeTutorialNTheme() {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Conversation(listMessage)
        }
    }
}
