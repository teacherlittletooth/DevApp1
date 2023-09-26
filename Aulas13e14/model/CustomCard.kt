package com.qi.instagreent.model

import com.qi.instagreent.R

data class CustomCard(
    var image: Int,
    var text: Int
)

var listCard = listOf(
    CustomCard(R.drawable.chaves, R.string.post1),
    CustomCard(R.drawable.suarez, R.string.post2),
    CustomCard(R.drawable.roberto, R.string.post3),
    CustomCard(R.drawable.jiraya, R.string.post4)
)
