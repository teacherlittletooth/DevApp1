package com.qi.aula10manha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qi.aula10manha.ui.theme.Aula10ManhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula10ManhaTheme {
               //
            }
        }
    }
}

@Composable
fun MySearchField(
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.secondary,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row(
            modifier = modifier.padding(10.dp)
        ) {
            Image(
                imageVector = Icons.Outlined.Search,
                contentDescription = null,
                modifier = modifier.size(30.dp)
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
    @DrawableRes image: Int = R.drawable.logo,
    @StringRes text: Int = R.string.teste
) {
    Surface(
        color = MaterialTheme.colorScheme.inversePrimary,
        shape = MaterialTheme.shapes.small,
        modifier = modifier.padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = modifier
                    .clip(CircleShape)
                    .size(60.dp)
                    .border(3.dp, Color.Gray, CircleShape)
            )

            Text(text = stringResource(id = text))
        }
    }
}

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int = R.drawable.logo,
    @StringRes text: Int = R.string.teste
) {
    Surface(
        color = MaterialTheme.colorScheme.inversePrimary,
        shape = MaterialTheme.shapes.small,
        modifier = modifier.padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.width(180.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = modifier.size(60.dp)
            )

            Text(
                text = stringResource(id = text),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
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
            x -> MyProfile(
                image = x.image,
                text = x.text
            )
        }
    }
}

@Composable
fun MyGridCard(
    modifier: Modifier = Modifier,
    list: List<Elements>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier.height(160.dp)
    ) {
        items(list) {
            y -> MyCard(
                text = y.text,
                image = y.image
            )
        }
    }
}

/////////////////////////////// PREVIEW ////////////////////////////
@Preview(showBackground = true)
@Composable
fun MySearchFieldPreview() {
    Aula10ManhaTheme {
        MySearchField()
    }
}

@Preview(showBackground = true)
@Composable
fun MyCarouselPreview() {
    Aula10ManhaTheme {
        MyCarousel(list = listElements)
    }
}

@Preview(showBackground = true)
@Composable
fun MyGridPreview() {
    Aula10ManhaTheme {
        MyGridCard(list = listElements)
    }
}

/////////////////////////////// DADOS ////////////////////////////
data class Elements(
    var image: Int = R.drawable.logo,
    var text: Int = R.string.teste
)

val listElements = listOf(
    Elements(),
    Elements(),
    Elements(),
    Elements(),
    Elements(),
    Elements()
)
