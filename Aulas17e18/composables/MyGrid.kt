package com.qi.finalproject.composables

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qi.finalproject.model.Item
import com.qi.finalproject.model.listItem

@Composable
fun MyGrid(
    modifier: Modifier = Modifier,
    list: List<Item>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(list) {
                MyCardState(
                    img = it.image,
                    txt = it.text
                )
            }
        }
    )
}

/////////////////////////
@Preview
@Composable
fun GridPreview() {
    MyGrid(list = listItem)
}