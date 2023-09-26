package com.qi.instagreent.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qi.instagreent.R
import com.qi.instagreent.model.CustomCard
import com.qi.instagreent.model.listCard
import com.qi.instagreent.ui.theme.InstagreenTTheme

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    like: Boolean = false,
    onLikeChange: () -> Unit,
    @StringRes text: Int
) {
    Card(
        modifier = modifier.padding(10.dp)
    ) {
       Column {
           Image(
               painter = painterResource(id = image),
               contentDescription = null,
               contentScale = ContentScale.FillWidth,
               modifier = modifier.fillMaxWidth()
           )
           IconButton(
               onClick = onLikeChange
           ) {
               Icon(
                   imageVector =
                        if(like) Icons.Default.Favorite
                        else Icons.Default.FavoriteBorder,
                   contentDescription = null
               )
           }
           Divider(thickness = 1.dp)
           Text(
               text = stringResource(id = text),
               style = MaterialTheme.typography.bodyMedium,
               modifier = modifier.padding(10.dp)
           )
       }
    }
}

@Composable
fun MyCardState(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int = R.drawable.ic_launcher_background,
    @StringRes text: Int = R.string.example
) {
    var check by remember {
        mutableStateOf(false)
    }

    MyCard(
        like = check,
        image = image,
        text = text,
        onLikeChange = { check = !check }
    )
}


@Composable
fun MyListCard(
    modifier: Modifier = Modifier,
    list: List<CustomCard>
) {
    LazyColumn {
        items(list) {
            value -> MyCardState(
                image = value.image,
                text = value.text
            )
        }
    }
}

/////////////////////////////////////
@Preview
@Composable
fun CardPreview() {
    InstagreenTTheme {
        MyListCard(list = listCard)
    }
}