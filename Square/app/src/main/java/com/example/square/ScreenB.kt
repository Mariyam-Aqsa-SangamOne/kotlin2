package com.example.square


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions


@Composable
fun FactScreen(
    onBack:()->Unit,
    onNext:()->Unit
)
{
    var input by remember{ mutableStateOf(("")) }
    var result by remember { mutableStateOf("") }
    val number=input.toIntOrNull()
    val isValid=number!= null && number in 1..10

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(35.dp)
    ) {

        Button(onClick=onBack){
            Text("Back")
        }

        Spacer(modifier= Modifier.height(16.dp))

        OutlinedTextField(
            value=input,
            onValueChange = {
                input=it
                result=""
            },
            label = {Text("Enter number (1-10)")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier= Modifier.height(16.dp))

        Button(
            onClick = {
                val n=number!!
                val square=n*n
                val cube=n*n*n
                val fact=factorial(n)
                result="""
                    Square:$square
                    Cube:$cube
                    Factorial:$fact
                """.trimIndent()
            },
            enabled = isValid,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                disabledContainerColor = Color.LightGray
            )
        ) {
            Text("Submit")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNext) {
            Text("Next")
        }

        Spacer(modifier= Modifier.height(16.dp))
        Text(text = result)
    }

}

fun factorial(n: Int):Int{
    var res=1
    for(i in 2..n){
        res*=i
    }
    return res
}