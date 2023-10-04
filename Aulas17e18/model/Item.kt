package com.qi.finalproject.model

import com.qi.finalproject.R

data class Item(
    var image: Int,
    var text: String
)

val listItem = listOf<Item>(
    Item(R.drawable.ic_launcher_foreground, "Futebol"),
    Item(R.drawable.ic_launcher_foreground, "Basquete"),
    Item(R.drawable.ic_launcher_foreground, "Vôlei"),
    Item(R.drawable.ic_launcher_foreground, "Tênis"),
    Item(R.drawable.ic_launcher_foreground, "Beisebol"),
    Item(R.drawable.ic_launcher_foreground, "Bolita")
)