package com.example.assignment3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Screen3A() {
    var input by remember { mutableStateOf("") }
    var permutations by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Assignment 3A",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = input,
            onValueChange = {
                if (it.length <= 6) {
                    input = it.uppercase()
                }
            },
            label = {
                Text("Enter word (max 6 chars)")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                permutations = generatePermutations(input)
            },
            enabled = input.isNotEmpty()
        ) {
            Text("Generate")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Total: ${permutations.size}")

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            items(permutations) { word ->
                Text(word)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

fun generatePermutations(str: String): List<String> {
    if (str.length == 1) {
        return listOf(str)
    }

    val result = mutableListOf<String>()

    for (i in str.indices) {
        val currentChar = str[i]
        val remainingChars = str.removeRange(i, i + 1)

        val subPermutations = generatePermutations(remainingChars)

        for (perm in subPermutations) {
            result.add(currentChar + perm)
        }
    }

    return result
}