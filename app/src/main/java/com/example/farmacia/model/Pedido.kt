package com.example.farmacia.model

/**
 * Enumeración para los estados del seguimiento del pedido.
 */
enum class EstadoPedido {
    PENDIENTE,
    EN_PREPARACION,
    EN_CAMINO,
    ENTREGADO,
    CANCELADO
}

/**
 * Enumeración para las opciones de pago disponibles.
 */
enum class MetodoPago {
    EFECTIVO,
    TARJETA,
    TRANSFERENCIA
}

/**
 * Representa la orden de compra confirmada.
 * Aplica validaciones de reglas de negocio en `init` (e.g. requerimiento de receta).
 */
data class Pedido(
    override val id: String,
    val cliente: Cliente,
    val items: List<CarritoItem>,
    val total: Double,
    val fecha: String,
    var estado: EstadoPedido = EstadoPedido.PENDIENTE,
    val metodoPago: MetodoPago,
    val recetaAsociada: RecetaMedica? = null
) : Identificable {

    init {
        val contieneMedicamentoControlado = items.any { it.producto.requiereReceta }
        if (contieneMedicamentoControlado) {
            require(recetaAsociada != null) {
                "El pedido incluye medicamentos controlados y requiere una receta médica adjunta."
            }
        }
    }
}
