package com.example.a1a

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CatandDogScreen(modifier: Modifier = Modifier) {
    val context= LocalContext.current
    val catsound= MediaPlayer.create(
        context,
        R.raw.meow
    )
    val dogsound= MediaPlayer.create(
        context,
        R.raw.bowbow
    )
    Row(
        modifier=modifier
    ){
        Image(
            painter=painterResource(id=R.drawable.cat),
            contentDescription = "Cat",
            modifier=modifier
                .size(250.dp)
                .clickable{
                    catsound.start()
                },
            contentScale = ContentScale.Fit
        )
        Image(
            painter=painterResource(id=R.drawable.dog),
            contentDescription = "Dog",
            modifier=modifier
                .size(250.dp)
                .clickable{
                    dogsound.start()
                },
            contentScale = ContentScale.Fit
        )

    }


}