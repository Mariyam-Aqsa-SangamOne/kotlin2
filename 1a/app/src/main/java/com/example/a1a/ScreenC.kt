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
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text

@Composable
fun cowandelephant(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context= LocalContext.current
    val catsound= MediaPlayer.create(
        context,
        R.raw.meow
    )
    val dogsound= MediaPlayer.create(
        context,
        R.raw.bowbow
    )
    val cowsound= MediaPlayer.create(
        context,
        R.raw.cow
    )
    val elesound= MediaPlayer.create(
        context,
        R.raw.elephant
    )
    val goatsound= MediaPlayer.create(
        context,
        R.raw.goat
    )
    val lionsound= MediaPlayer.create(
        context,
        R.raw.lion
    )



    Column{
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
            Text(
                    text = "Hello, !"
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

        Row(
            modifier=modifier
        ) {
            Image(
                painter = painterResource(id = R.drawable.cow),
                contentDescription = "Cat",
                modifier = modifier
                    .size(250.dp)
                    .clickable {
                        cowsound.start()
                    },
                contentScale = ContentScale.Fit
            )
            Image(
                painter=painterResource(id=R.drawable.elephant),
                contentDescription = "Elephant",
                modifier=modifier
                    .size(250.dp)
                    .clickable{
                        elesound.start()
                    },
                contentScale = ContentScale.Fit
            )
        }
        Row(
            modifier=modifier
        ) {
            Image(
                painter = painterResource(id = R.drawable.goat),
                contentDescription = "Goat",
                modifier = modifier
                    .size(250.dp)
                    .clickable {
                        goatsound.start()
                    },
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(id = R.drawable.lion),
                contentDescription = "Lion",
                modifier = modifier
                    .size(250.dp)
                    .clickable {
                        lionsound.start()
                    },
                contentScale = ContentScale.Fit
            )
        }


        Button(
            onClick = {
                navController.navigate("catDogScreen")
            }
        ) {
            Text("Previous")
        }
        Button(
            onClick = {
                navController.navigate("GalleryScreen")
            }
        ) {
            Text("Next")
        }
    }



}