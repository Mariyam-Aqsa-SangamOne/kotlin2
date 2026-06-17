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
fun TableScreen(modifier: Modifier = Modifier) {

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
            TableCell("Number", isHeader = true)
            TableCell("Square", isHeader = true)
        }

        for (i in 1..10) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TableCell("$i\t\t\t")
                TableCell("\t\t\t${i * i}")
            }
        }
    }
}

@Composable
fun TableCell(text: String, isHeader: Boolean = false) {

    Box(
        modifier = Modifier
            .border(1.dp, Color.Black)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = if (isHeader)
                MaterialTheme.typography.titleMedium
            else
                MaterialTheme.typography.bodyMedium
        )
    }
}