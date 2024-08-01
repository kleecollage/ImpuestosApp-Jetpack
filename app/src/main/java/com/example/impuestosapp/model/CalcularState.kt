package com.example.impuestosapp.model
// generalmente estas clases terminan en "Model",
// en este caso se "State" por que unicamente modifican el estado
data class CalcularState(
    val precio: String = "",
    val iva: String = "",
    val arancel: String = "",
    val precioIVA: Double = 0.0,
    val precioAranceles: Double = 0.0,
    val totalImpuesto: Double = 0.0,
    val showAlert: Boolean = false
)
