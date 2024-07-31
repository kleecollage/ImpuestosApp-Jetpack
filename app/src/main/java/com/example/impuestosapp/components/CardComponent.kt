package com.example.impuestosapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThreeCards(title1: String, number1: Double, title2: String, number2: Double, title3: String, number3: Double) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MainCard(
            title = title1,
            number = number1,
            modifier = Modifier
                .padding(start = 24.dp)
                .weight(1f)
            )

        MainCard(
            title = title2,
            number = number2,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .weight(1f)
        )

        MainCard(
            title = title3,
            number = number3,
            modifier = Modifier
                .padding(end = 24.dp)
                .weight(1f)
        )
    }
}

@Composable
fun MainCard(title: String, number: Double, modifier: Modifier = Modifier) {
    Card(
        modifier= modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = title, color = Color.Black, fontSize = 20.sp)
            Text(text = "$$number", color = Color.Black, fontSize = 20.sp)
        }
    }
}

fun calcularPrecio(precio: Double, iva: Double, arancel: Double): Double {
    val res = precio + iva + arancel
    return kotlin.math.round(res * 100 ) / 100.0
}

fun calcularIVA(precio: Double, iva: Double): Double {
    val res = precio * ( iva / 100 )
    return kotlin.math.round(res * 100 ) / 100.0
}

fun calcularAranceles(precio: Double, arancel: Double): Double {
    val res = precio * ( arancel / 100 )
    return kotlin.math.round(res * 100 ) / 100.0
}