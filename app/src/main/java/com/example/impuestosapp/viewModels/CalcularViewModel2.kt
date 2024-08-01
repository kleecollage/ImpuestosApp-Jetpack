package com.example.impuestosapp.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcularViewModel2: ViewModel() {
    private val _precio = mutableStateOf("")
    val precio1: State<String> = _precio

    // La siguiente forma es igual que la anterior pero mas directa
    var precio by mutableStateOf("")
        private set
    // si se requiere usar onChange se deben crear funciones de la siguiente manera
    fun onValuePrecio(value: String){
        precio = value
    }
    /*
    fun onValueIva(value: String){
        iva = value
    }
    fun onValueArancel(value: String){
        arancel = value
    }
    */

    var iva by mutableStateOf("")
        private set

    var arancel by mutableStateOf("")
        private set
    // para formularios mas grandes se simplica el codigo en una sola funcion
    fun onValue(value: String, text: String){
        when(text) {
            "iva" -> iva = value
            "arancel" -> arancel = value
            // otras variables ... //
            // otras variables ... //
            // otras variables ... //
            // otras variables ... //
        }
    }


    var precioIVA by mutableStateOf(0.0)
        private set

    var precioAranceles by mutableStateOf(0.0)
        private set

    var totalImpuesto by mutableStateOf(0.0)
        private set

    var showAlert by mutableStateOf(false)
        private set

    fun calc() {
        _precio.value = "newVal" // se debe especificar .value en esta variable
        precio = "newVal" // se puede modificar el valor directamente
    }

    fun calcular(){
        if (precio != "" && iva != "" && arancel != ""){
            precioAranceles = calcularAranceles(precio.toDouble(), arancel.toDouble())
            precioIVA = calcularIVA(precio.toDouble(), iva.toDouble())
            totalImpuesto = calcularPrecio(precio.toDouble(), precioIVA, precioAranceles)
        } else showAlert = true

    }

    fun limpiar() {
        precio = ""
        iva = ""
        arancel = ""
        totalImpuesto = 0.0
        precioIVA = 0.0
        precioAranceles = 0.0
    }

    fun cancelAlert() {
        showAlert = false
    }

    private fun calcularPrecio(precio: Double, iva: Double, arancel: Double): Double {
        val res = precio + iva + arancel
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