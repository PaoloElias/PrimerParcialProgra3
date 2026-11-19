package com.example.farmacia.ui.data

import com.example.farmacia.model.Categoria
import com.example.farmacia.model.Producto

object MockData {
    val categorias = listOf(
        Categoria("cat_1", "Todos", "Todos los productos disponibles"),
        Categoria("cat_2", "Analgésicos", "Alivio del dolor y la fiebre"),
        Categoria("cat_3", "Antibióticos", "Tratamiento de infecciones bacterianas"),
        Categoria("cat_4", "Vitaminas", "Suplementos para la salud"),
        Categoria("cat_5", "Cuidado Personal", "Higiene y dermo-cosmética")
    )

    val productos = listOf(
        Producto(
            id = "prod_1",
            nombre = "Paracetamol 500mg",
            descripcion = "Alivio efectivo del dolor moderado y la fiebre.",
            precio = 15.50,
            stock = 50,
            requiereReceta = false,
            presentacion = "Caja con 20 tabletas",
            codigoBarras = "7701234567890",
            laboratorio = "Lab. Genfar",
            categoria = categorias[1]
        ),
        Producto(
            id = "prod_2",
            nombre = "Amoxicilina 500mg",
            descripcion = "Antibiótico de amplio espectro para infecciones.",
            precio = 32.00,
            stock = 15,
            requiereReceta = true,
            presentacion = "Caja con 12 cápsulas",
            codigoBarras = "7701234567891",
            laboratorio = "Lab. MK",
            categoria = categorias[2]
        ),
        Producto(
            id = "prod_3",
            nombre = "Vitamina C 1000mg",
            descripcion = "Suplemento efervescente para fortalecer las defensas.",
            precio = 22.50,
            stock = 30,
            requiereReceta = false,
            presentacion = "Tubo con 20 tabletas",
            codigoBarras = "7701234567892",
            laboratorio = "Lab. Redoxon",
            categoria = categorias[3]
        ),
        Producto(
            id = "prod_4",
            nombre = "Ibuprofeno 400mg",
            descripcion = "Antiinflamatorio para dolores musculares y articulares.",
            precio = 18.00,
            stock = 40,
            requiereReceta = false,
            presentacion = "Caja con 10 cápsulas blandas",
            codigoBarras = "7701234567893",
            laboratorio = "Lab. Bayer",
            categoria = categorias[1]
        ),
        Producto(
            id = "prod_5",
            nombre = "Azitromicina 500mg",
            descripcion = "Antibiótico para infecciones de vías respiratorias.",
            precio = 45.00,
            stock = 8,
            requiereReceta = true,
            presentacion = "Caja con 3 tabletas",
            codigoBarras = "7701234567894",
            laboratorio = "Lab. Pfizer",
            categoria = categorias[2]
        ),
        Producto(
            id = "prod_6",
            nombre = "Protector Solar SPF 50+",
            descripcion = "Alta protección dermatológica UVA/UVB.",
            precio = 85.00,
            stock = 20,
            requiereReceta = false,
            presentacion = "Frasco 200ml",
            codigoBarras = "7701234567895",
            laboratorio = "Lab. Isdin",
            categoria = categorias[4]
        )
    )
}
