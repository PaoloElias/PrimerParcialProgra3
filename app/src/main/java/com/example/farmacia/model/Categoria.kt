package com.example.farmacia.model

/**
 * Representa la categoría a la que pertenece un producto farmacéutico.
 */
data class Categoria(
    override val id: String,
    val nombre: String,
    val descripcion: String,
    val iconoUrl: String = ""
) : Identificable
