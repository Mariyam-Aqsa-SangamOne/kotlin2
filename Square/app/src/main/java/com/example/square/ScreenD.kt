package com.example.square

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun TableSwipeScreen(
    onBack: () -> Unit,
    onNext: () -> Unit
) {
    var currentNumber by remember {
        mutableStateOf(3)
    }

    var totalDrag by remember {
        mutableStateOf(0f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onHorizontalDrag = { _, dragAmount ->
                        totalDrag += dragAmount
                    },
                    onDragEnd = {
                        if (totalDrag < -100) {
                            currentNumber =
                                if (currentNumber == 99) 2
                                else currentNumber + 1
                        } else if (totalDrag > 100) {
                            currentNumber =
                                if (currentNumber == 2) 99
                                else currentNumber - 1
                        }
                        totalDrag = 0f
                    }
                )
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = onBack) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Mathematical Table of $currentNumber",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        for (i in 1..10) {
            Text(
                text = "$currentNumber × $i = ${currentNumber * i}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onNext) {
            Text("Next")
        }
    }
}