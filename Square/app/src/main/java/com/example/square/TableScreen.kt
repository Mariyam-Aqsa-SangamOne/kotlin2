package com.example.square

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun TableScreen(
    onNavigateToCalc:()->Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {

        Text(
            text = "Number and Square Table",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Number",
                modifier=Modifier
                    .weight(1f)
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
            )

            Text("Sqaure",
                modifier=Modifier
                    .weight(1f)
                    .border(1.dp, Color.Black)
                    .padding(8.dp)
            )
        }

        for (i in 1..10) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text("$i",
                    modifier=Modifier
                        .weight(1f)
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                )
                Text("${i * i}",
                    modifier=Modifier
                        .weight(1f)
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                )
            }
        }
        Button(onClick = onNavigateToCalc) {
            Text("Next")
        }
    }
}