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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.draw.scale
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Alignment

@Composable
fun GalleryScreen(
    navController: NavController) {
    val animallist = listOf(
        animal("Cat", R.drawable.cat),
        animal("Dog", R.drawable.dog),
        animal("Elephant", R.drawable.elephant),
        animal("Goat", R.drawable.goat),
        animal("Cow", R.drawable.cow),
        animal("Lion", R.drawable.lion),
        animal("Cock", R.drawable.cock),
        animal("Peacock", R.drawable.peacock),
        animal("Duck", R.drawable.duck),
        animal("Eagle", R.drawable.eagle),
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Button(
            onClick = {
                navController.navigate("CowandElephant")
            },
            modifier = Modifier.padding(15.dp)
        ) {
            Text("Previous")
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            items(animallist) { animal ->

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = animal.image),
                        contentDescription = animal.name,
                        modifier = Modifier.size(200.dp)
                    )
                    Text(
                        text = animal.name
                    )
                }
            }
        }


    }
}




