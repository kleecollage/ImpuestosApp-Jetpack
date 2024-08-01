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
import com.example.impuestosapp.viewModels.CalcularViewModel2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView2(viewModel2: CalcularViewModel2) {
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
        ContentHomeView2(it, viewModel2)
    }
};

@Composable
fun ContentHomeView2(paddingValues: PaddingValues, viewModel2: CalcularViewModel2) {
    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(10.dp)
        .fillMaxSize(),
        // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ThreeCards(
            title1 = "Total",
            number1 = viewModel2.totalImpuesto,
            title2 = "IVA",
            number2 = viewModel2.precioIVA,
            title3 = "Aranceles",
            number3 = viewModel2.precioAranceles
        )

        MainTextField(value = viewModel2.precio, onValueChange = { viewModel2.onValuePrecio(it) }, label = "Precio")
        SpaceH()
        MainTextField(value = viewModel2.iva, onValueChange = { viewModel2.onValue(it, "iva") }, label = "% IVA")
        SpaceH()
        MainTextField(value = viewModel2.arancel, onValueChange = { viewModel2.onValue(it, "arancel") }, label = "% Aranceles")
        SpaceH(10.dp)

        MainButton(text = "Generar Impuestos") {
            viewModel2.calcular()
        }
        SpaceH()

        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel2.limpiar()
        }

        if (viewModel2.showAlert){
            Alert(
                title = "Alerta",
                message = "Debes llenar todos los campos",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel2.cancelAlert() },
            ) {}
        }
    }
}






















