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
fun ScreenC(
    onBack:()->Unit,
    onNext:()->Unit
)
{
    var input1 by remember{ mutableStateOf(("")) }
    var input2 by remember{ mutableStateOf(("")) }
    var result by remember { mutableStateOf("") }
    val number1=input1.toIntOrNull()
    val number2=input2.toIntOrNull()
    val isValid1=number1!= null && number1 in 1..100
    val isValid2=number2!= null && number2 in 1..100

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
            value=input1,
            onValueChange = {
                input1=it
                result=""
            },
            label = {Text("Enter number (1-100)")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value=input2,
            onValueChange = {
                input2=it
                result=""
            },
            label = {Text("Enter number (1-100)")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier= Modifier.height(16.dp))

        Button(
            onClick = {
                val n1=number1!!
                val n2=number2!!
                val add=n1+n2
                val sub=n1-n2
                val mul=n1*n2
                val div=n1.toDouble()/n2
                val intDiv=n1/n2
                val rem=n1%n2
                val exp=Math.pow(n1.toDouble(),n2.toDouble())
                val hcf=findHCF(n1,n2)
                val lcm=(n1*n2)/hcf
                result="""
                    Addition:$add
                    Subtraction:$sub
                    Multiplication:$mul
                    Division:$div
                    Integer Division:$intDiv
                    Remainder:$rem
                    Exponential:$exp
                    HCF:$hcf
                    LCM:$lcm
                """.trimIndent()
            },
            enabled = isValid1 && isValid2,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                disabledContainerColor = Color.LightGray
            )
        )
        {
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

fun findHCF(a:Int,b: Int):Int{
    var x=a
    var y=b

    while(y!=0){
        val temp=y
        y=x%y
        x=temp
    }
    return x

}