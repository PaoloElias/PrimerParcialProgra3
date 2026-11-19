package com.example.farmacia.model

/**
 * Enumeración para los estados posibles de validación de una receta médica.
 */
enum class EstadoReceta {
    PENDIENTE,
    APROBADA,
    RECHAZADA
}

/**
 * Representa la receta médica requerida para productos controlados.
 */
data class RecetaMedica(
    override val id: String,
    val clienteId: String,
    val nombreMedico: String,
    val cedulaProfesional: String,
    val fechaEmision: String,
    val imagenUrl: String,
    var estado: EstadoReceta = EstadoReceta.PENDIENTE
) : Identificable {

    val esValida: Boolean
        get() = estado == EstadoReceta.APROBADA
}
