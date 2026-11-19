package com.example.farmacia.model

/**
 * Clase de dominio que representa un producto/medicamento en la farmacia.
 * Aplica Encapsulación validando invariants en el bloque init y propiedades calculadas.
 */
data class Producto(
    override val id: String,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val stock: Int,
    val requiereReceta: Boolean,
    val presentacion: String,
    val codigoBarras: String,
    val laboratorio: String,
    val categoria: Categoria
) : Identificable {

    init {
        require(precio >= 0.0) { "El precio no puede ser negativo." }
        require(stock >= 0) { "El stock no puede ser negativo." }
    }

    val disponible: Boolean
        get() = stock > 0
}
