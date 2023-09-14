package com.qi.aula10noite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qi.aula10noite.ui.theme.Aula10NoiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula10NoiteTheme {
               MySearchField()
            }
        }
    }
}

@Composable
fun MySearchField(
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier.padding(10.dp)
        ) {
            Image(
                imageVector = Icons.Outlined.Search,
                contentDescription = null
            )

            Spacer(modifier = modifier.width(10.dp))

            BasicTextField(
                value = "",
                onValueChange = { }
            )
        }
    }
}


@Composable
fun MyProfile(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes text: Int
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier.padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

            Text(text = stringResource(id = text))
        }
    }
}


@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes text: Int
) {
    Surface(
        color = MaterialTheme.colorScheme.inverseOnSurface,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.width(200.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = modifier.size(60.dp)
            )

            Text(
                text = stringResource(id = text),
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun MyCarousel(
    modifier: Modifier = Modifier,
    list: List<Elements>
) {
    LazyRow {
        items(list) {
            l -> MyProfile(
                    image = l.image,
                    text = l.text
                )
        }
    }
}


@Composable
fun MyCardGrid(
    modifier: Modifier = Modifier,
    list: List<Elements>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier.height(160.dp)
    ) {
        items(list) {
            l -> MyCard(
                    image = l.image,
                    text = l.text
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Aula10NoiteTheme {
        MyCardGrid(list = listElements)
    }
}


data class Elements(
    var image: Int,
    var text: Int
)

val listElements = listOf(
    Elements(
        R.drawable.ic_launcher_background,
        R.string.teste
    ),
    Elements(
        R.drawable.ic_launcher_background,
        R.string.teste
    ),
    Elements(
        R.drawable.ic_launcher_background,
        R.string.teste
    ),
    Elements(
        R.drawable.ic_launcher_background,
        R.string.teste
    ),
    Elements(
        R.drawable.ic_launcher_background,
        R.string.teste
    ),
    Elements(
        R.drawable.ic_launcher_background,
        R.string.teste
    )
)
