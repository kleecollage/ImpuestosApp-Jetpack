package com.example.impuestosapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.impuestosapp.components.Alert
import com.example.impuestosapp.components.MainButton
import com.example.impuestosapp.components.MainTextField
import com.example.impuestosapp.components.SpaceH
import com.example.impuestosapp.components.ThreeCards
import com.example.impuestosapp.components.calcularAranceles
import com.example.impuestosapp.components.calcularIVA
import com.example.impuestosapp.components.calcularPrecio
import com.example.impuestosapp.viewModels.CalcularViewModel1
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel1: CalcularViewModel1) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "App Impuestos", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentHomeView(it, viewModel1)
    }
};

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel1: CalcularViewModel1) {
    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(10.dp)
        .fillMaxSize(),
        // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var iva by remember { mutableStateOf("") }
        var arancel by remember { mutableStateOf("") }
        var precioIVA by remember { mutableStateOf(0.0) }
        var precioAranceles by remember { mutableStateOf(0.0) }
        var totalImpuesto by remember { mutableStateOf(0.0) }
        var showAlert by remember { mutableStateOf(false) }

        ThreeCards(
            title1 = "Total",
            number1 = totalImpuesto,
            title2 = "IVA",
            number2 = precioIVA,
            title3 = "Aranceles",
            number3 = precioAranceles
        )

        MainTextField(value = precio, onValueChange = { precio = it }, label = "Precio")
        SpaceH()
        MainTextField(value = iva, onValueChange = { iva = it }, label = "% IVA")
        SpaceH()
        MainTextField(value = arancel, onValueChange = { arancel = it }, label = "% Aranceles")
        SpaceH(10.dp)

        MainButton(text = "Generar Impuestos") {
            val result = viewModel1.calcular(precio, iva, arancel)
            showAlert = result.second.second.second
            if (!showAlert){
                precioAranceles = result.second.second.first
                precioIVA = result.second.first
                totalImpuesto = result.first
            }
        }
        SpaceH()

        MainButton(text = "Limpiar", color = Color.Red) {
            precio = ""
            iva = ""
            arancel = ""
            precioIVA = 0.00
            precioAranceles = 0.00
            totalImpuesto = 0.00
        }

        if (showAlert){
            Alert(
                title = "Alerta",
                message = "Debes llenar todos los campos",
                confirmText = "Aceptar",
                onConfirmClick = { showAlert = false },
            ) {}
        }
    }
}






















