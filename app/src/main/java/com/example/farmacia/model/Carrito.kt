package com.example.farmacia.model

/**
 * Representa un elemento dentro del carrito de compras.
 */
data class CarritoItem(
    val producto: Producto,
    var cantidad: Int
) {
    init {
        require(cantidad > 0) { "La cantidad debe ser mayor a cero." }
    }

    val subtotal: Double
        get() = producto.precio * cantidad
}

/**
 * Encapsula la gestión de los productos seleccionados antes de la compra.
 * Aplica el principio de Encapsulación ocultando la lista mutable interna (`_items`).
 */
class Carrito {
    private val _items = mutableListOf<CarritoItem>()

    val items: List<CarritoItem>
        get() = _items.toList()

    val total: Double
        get() = _items.sumOf { it.subtotal }

    val requiereReceta: Boolean
        get() = _items.any { it.producto.requiereReceta }

    fun agregarProducto(producto: Producto, cantidad: Int = 1) {
        val existente = _items.find { it.producto.id == producto.id }
        if (existente != null) {
            existente.cantidad += cantidad
        } else {
            _items.add(CarritoItem(producto, cantidad))
        }
    }

    fun eliminarProducto(productoId: String) {
        _items.removeAll { it.producto.id == productoId }
    }

    fun actualizarCantidad(productoId: String, nuevaCantidad: Int) {
        if (nuevaCantidad <= 0) {
            eliminarProducto(productoId)
        } else {
            val existente = _items.find { it.producto.id == productoId }
            existente?.cantidad = nuevaCantidad
        }
    }

    fun vaciar() {
        _items.clear()
    }
}
