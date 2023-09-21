package com.qi.watercountm.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qi.watercountm.R


@Composable
fun WaterCountState(
    modifier: Modifier = Modifier
) {
    var counter by remember {
        mutableStateOf(0)
    }

    WaterCount(
        count = counter,
        onIncrement = { counter++ },
        onReset = { counter = 0 }
    )
}


@Composable
fun WaterCount(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit,
    onReset: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = onIncrement,
                enabled = count < 10,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(text = stringResource(id = R.string.btn_more))
            }

            Button(
                onClick = onReset,
                enabled = count > 0,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(text = stringResource(id = R.string.btn_reset))
            }
        }

        Divider(
            thickness = 2.dp,
            modifier = modifier
                .padding(15.dp)
                .border(
                    5.dp,
                    Brush.horizontalGradient(listOf(Color.Blue, Color.White, Color.Black)),
                    RectangleShape
                )
        )

        Text(
            text = stringResource(id = R.string.message),
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
            modifier = modifier.fillMaxWidth()
        )

        Text(
            text = "$count",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            ),
            modifier = modifier.fillMaxWidth()
        )

        Spacer(modifier = modifier.height(30.dp))

        LinearProgressIndicator(
            progress = count/10.toFloat(),
            modifier = modifier.fillMaxWidth()
                               .padding(horizontal = 20.dp),
            color = Color.Blue
        )
    }
}
