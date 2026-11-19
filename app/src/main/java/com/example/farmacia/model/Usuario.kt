package com.example.farmacia.model

/**
 * Clase abstracta base que representa a un usuario del sistema.
 * Demuestra los principios de Herencia y Abstracción.
 */
abstract class Usuario(
    override val id: String,
    open val nombreCompleto: String,
    open val email: String
) : Identificable

/**
 * Objeto de valor (Value Object) que representa la dirección física de envío.
 */
data class Direccion(
    val calle: String,
    val numero: String,
    val colonia: String,
    val ciudad: String,
    val codigoPostal: String
) {
    fun obtenerDireccionCompleta(): String {
        return "$calle #$numero, Col. $colonia, $ciudad, C.P. $codigoPostal"
    }
}

/**
 * Subclase concreta que representa a un cliente en la aplicación.
 * Aplica Herencia extendiendo de [Usuario].
 */
data class Cliente(
    override val id: String,
    override val nombreCompleto: String,
    override val email: String,
    val telefono: String,
    val direccionEnvio: Direccion
) : Usuario(id, nombreCompleto, email)
