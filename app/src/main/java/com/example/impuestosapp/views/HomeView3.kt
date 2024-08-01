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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.impuestosapp.components.Alert
import com.example.impuestosapp.components.MainButton
import com.example.impuestosapp.components.MainTextField
import com.example.impuestosapp.components.SpaceH
import com.example.impuestosapp.components.ThreeCards
import com.example.impuestosapp.viewModels.CalcularViewModel3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView3(viewModel3: CalcularViewModel3) {
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
        ContentHomeView3(it, viewModel3)
    }
};

@Composable
fun ContentHomeView3(paddingValues: PaddingValues, viewModel3: CalcularViewModel3) {
    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(10.dp)
        .fillMaxSize(),
        // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = viewModel3.state

        ThreeCards(
            title1 = "Total",
            number1 = state.totalImpuesto,
            title2 = "IVA",
            number2 = state.precioIVA,
            title3 = "Aranceles",
            number3 = state.precioAranceles
        )

        MainTextField(value = state.precio, onValueChange = { viewModel3.onValue(it, "precio") }, label = "Precio")
        SpaceH()
        MainTextField(value = state.iva, onValueChange = { viewModel3.onValue(it, "iva") }, label = "% IVA")
        SpaceH()
        MainTextField(value = state.arancel, onValueChange = { viewModel3.onValue(it, "arancel") }, label = "% Aranceles")
        SpaceH(10.dp)

        MainButton(text = "Generar Impuestos") {
            viewModel3.calcular()
        }
        SpaceH()

        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel3.limpiar()
        }

        if (state.showAlert){
            Alert(
                title = "Alerta",
                message = "Debes llenar todos los campos",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel3.cancelAlert() },
            ) {}
        }
    }
}






















