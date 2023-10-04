package com.qi.finalproject.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qi.finalproject.R

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    text: String,
    check: Boolean,
    onCheck: (Boolean) -> Unit
) {
    Card(
        modifier = modifier.padding(5.dp),
        content = {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = modifier.padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = modifier.fillMaxWidth()
                )
                Column(
                    modifier = modifier.padding(bottom = 10.dp)
                ) {
                    Divider(
                        thickness = 2.dp,
                        modifier = modifier.padding(15.dp)
                    )
                    Row(
                        modifier = modifier.fillMaxWidth()
                                           .padding(horizontal = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = text)
                        Switch(
                            checked = check,
                            onCheckedChange = onCheck
                        )
                    } //Row
                } //Column
            } //Box
        }
    )
}

@Composable
fun MyCardState(
    modifier: Modifier = Modifier,
    @DrawableRes img: Int = R.drawable.ic_launcher_background,
    txt: String = "Texto"
) {
    var checkState by rememberSaveable {
        mutableStateOf(false)
    }

    MyCard(
        image = img,
        text = txt,
        check = checkState,
        onCheck = { newValue -> checkState = newValue }
    )
}

///////////////////////////////////
@Preview
@Composable
fun CardPreview() {
    MyCardState()
}