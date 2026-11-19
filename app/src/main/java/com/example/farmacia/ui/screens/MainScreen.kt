package com.example.farmacia.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.farmacia.model.Carrito
import com.example.farmacia.ui.theme.FarmaciaTheme

enum class FarmaciaTab {
    CATALOGO,
    CARRITO
}

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val carrito = remember { Carrito() }
    var cartStateVersion by remember { mutableIntStateOf(0) }

    fun refreshCartState() {
        cartStateVersion++
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Catálogo"
                        )
                    },
                    label = { Text("Catálogo") }
                )

                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        BadgedBox(
                            badge = {
                                @Suppress("UNUSED_EXPRESSION")
                                cartStateVersion
                                val count = carrito.items.sumOf { it.cantidad }
                                if (count > 0) {
                                    Badge { Text(count.toString()) }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Carrito"
                            )
                        }
                    },
                    label = { Text("Carrito") }
                )
            }
        }
    ) { innerPadding ->
        @Suppress("UNUSED_EXPRESSION")
        cartStateVersion

        when (selectedTab) {
            0 -> CatalogScreen(
                carritoCount = carrito.items.sumOf { it.cantidad },
                onNavigateToCart = { selectedTab = 1 },
                onAgregarAlCarrito = { producto ->
                    carrito.agregarProducto(producto, 1)
                    refreshCartState()
                },
                modifier = Modifier.padding(innerPadding)
            )
            1 -> CartScreen(
                items = carrito.items,
                onIncrementarCantidad = { productoId ->
                    val item = carrito.items.find { it.producto.id == productoId }
                    if (item != null) {
                        carrito.actualizarCantidad(productoId, item.cantidad + 1)
                        refreshCartState()
                    }
                },
                onDecrementarCantidad = { productoId ->
                    val item = carrito.items.find { it.producto.id == productoId }
                    if (item != null) {
                        carrito.actualizarCantidad(productoId, item.cantidad - 1)
                        refreshCartState()
                    }
                },
                onEliminarItem = { productoId ->
                    carrito.eliminarProducto(productoId)
                    refreshCartState()
                },
                onNavigateBack = { selectedTab = 0 },
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
