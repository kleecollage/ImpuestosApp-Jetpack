package com.example.impuestosapp.viewModels

import androidx.lifecycle.ViewModel

class CalcularViewModel1: ViewModel() {

    fun calcular(precio: String, iva: String, aranceles: String): Pair<Double, Pair<Double, Pair<Double, Boolean>>> {
        var totalImpuesto = 0.0
        var precioIVA = 0.0
        var precioAranceles = 0.0
        var showAlert = false

        if (precio != "" && iva != "" && aranceles != ""){
            precioAranceles = calcularAranceles(precio.toDouble(), aranceles.toDouble())
            precioIVA = calcularIVA(precio.toDouble(), iva.toDouble())
            totalImpuesto = calcularPrecio(precio.toDouble(), precioIVA, precioAranceles)
        } else showAlert = true

        return Pair(totalImpuesto, Pair(precioIVA, Pair(precioAranceles, showAlert)))
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