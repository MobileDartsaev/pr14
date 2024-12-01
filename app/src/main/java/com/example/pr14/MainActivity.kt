package com.example.pr14


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculator()
        }
    }
}

@Composable
fun SimpleCalculator() {
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Поле ввода 1
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(BorderStroke(1.dp, Color.Gray))
                .background(Color.White)
        ) {
            BasicTextField(value = input1, onValueChange = { input1 = it }, modifier = Modifier.padding(8.dp))
        }

        // Поле ввода 2
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(BorderStroke(1.dp, Color.Gray))
                .background(Color.White)
        ) {
            BasicTextField(value = input2, onValueChange = { input2 = it }, modifier = Modifier.padding(8.dp))
        }

        // Кнопки
        Button(onClick = {
            val num1 = input1.toDoubleOrNull() ?: 0.0
            val num2 = input2.toDoubleOrNull() ?: 0.0

            result = (num1 + num2).toString()
        }) {
            Text("Сложить")
        }

        Button(onClick = {
            val num1 = input1.toDoubleOrNull() ?: 0.0
            val num2 = input2.toDoubleOrNull() ?: 0.0

            result = (num1 - num2).toString()
        }) {
            Text("Вычесть")
        }

        Button(onClick = {
            val num1 = input1.toDoubleOrNull() ?: 0.0
            val num2 = input2.toDoubleOrNull() ?: 0.0

            result = (num1 * num2).toString()
        }) {
            Text("Умножить")
        }

        Button(onClick = {
            val num1 = input1.toDoubleOrNull() ?: 0.0
            val num2 = input2.toDoubleOrNull() ?: 0.0

            result = if (num2 == 0.0) {
                "Ошибка"
            } else {
                (num1 / num2).toString()
            }
        }) {
            Text("Разделить")
        }

        // Вывод результата
        Text("Результат: $result", modifier = Modifier.padding(16.dp))
    }
}