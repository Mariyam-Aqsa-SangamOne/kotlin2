package com.example.a1a

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text

@Composable
fun CatScreen(
    navController: NavController,
    modifier: Modifier = Modifier
    ) {
    val context= LocalContext.current
    val mediaPlayer= MediaPlayer.create(
        context,
        R.raw.meow
    )

    Column{
        Image(
            painter=painterResource(id=R.drawable.cat),
            contentDescription = "Cat",
            modifier=modifier
                .size(250.dp)
                .clickable{
                    mediaPlayer.start()
                },
            contentScale = ContentScale.Fit
        )

        Button(
            onClick = {
                navController.navigate("catDogScreen")
            }
        ) {
            Text("Next")
        }
    }

}
