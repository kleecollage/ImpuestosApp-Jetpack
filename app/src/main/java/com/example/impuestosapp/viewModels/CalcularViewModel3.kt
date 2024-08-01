package com.example.impuestosapp.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.impuestosapp.model.CalcularState

class CalcularViewModel3: ViewModel() {
    // a continuacion se extraen todas las variables en una sola linea
    var state by mutableStateOf(CalcularState())
        private set
    
    // si se requiere modificar las variables se usa la funcion copy
    fun onValue(value: String, text: String){
        when(text){
            "precio" -> state = state.copy(precio = value)
            "iva" -> state = state.copy(iva = value)
            "arancel" -> state = state.copy(arancel = value)
        }
    }

    fun calcular(){
        val precio = state.precio
        val iva = state.iva
        val arancel = state.arancel

        state = if (precio.isNotEmpty() && iva.isNotEmpty() && arancel.isNotEmpty()){
            state.copy(
                precioAranceles = calcularIVA(precio.toDouble(), iva.toDouble()),
                precioIVA = calcularAranceles(precio.toDouble(), arancel.toDouble()),
                totalImpuesto = calcularPrecio(precio.toDouble(), iva.toDouble(), arancel.toDouble())
            )
        } else state.copy(showAlert = true)
    }

    fun limpiar() {
        state = state.copy(
            precio = "",
            iva = "",
            arancel = "",
            totalImpuesto = 0.0,
            precioIVA = 0.0,
            precioAranceles = 0.0,
        )
    }

    fun cancelAlert() {
        state = state.copy(showAlert = false)
    }

    private fun calcularPrecio(precio: Double, iva: Double, arancel: Double): Double {
        val precioIVA = calcularIVA(precio, iva)
        val precioAranceles = calcularAranceles(precio, arancel)
        val res = precio + precioIVA + precioAranceles
        return kotlin.math.round(res * 100 ) / 100.0
    }

    private fun calcularIVA(precio: Double, iva: Double): Double {
        val res = precio * ( iva / 100 )
        return kotlin.math.round(res * 100 ) / 100.0
    }

    private fun calcularAranceles(precio: Double, arancel: Double): Double {
        val res = precio * ( arancel / 100 )
        return kotlin.math.round(res * 100 ) / 100.0
    }


}