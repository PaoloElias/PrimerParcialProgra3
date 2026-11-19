# Registro de Conversación y Prompts - Proyecto Farmacia

Este archivo contiene el historial completo de interacciones, diseños e implementaciones realizadas durante el desarrollo del proyecto **Farmacia** en Android con Kotlin y Jetpack Compose.

---

## Prompt 1
> **Usuario:**
> Haremos un proyecto deuna Farmacia, por el momento solo recuerda que tiene que ser la interfaz hecha con jetpack compose, pero primeramente en esta tenemos que tener un modelo o diagrama de clases, primero quiero que hagas eso, sin todavia empezar el codigo

### Respuesta del Asistente:
* Se analizó el dominio de la farmacia y se creó un modelo de clases y arquitectura en el artefacto `modelo_clases_farmacia.artifact.md`.
* Se definieron las entidades principales: `Producto`, `Categoria`, `Cliente`, `Direccion`, `RecetaMedica`, `CarritoItem`, `Carrito` y `Pedido`.
* Se incluyeron diagramas en Mermaid para el diagrama de clases conceptual y la arquitectura MVVM propuesta para Jetpack Compose.

---

## Prompt 2
> **Usuario:**
> Continuando con el diagrama de clases, quiero que implementes en kotlin las clases que creaste, en el checkpoint anterior, aplica conceptos de programacion orientadaa objectos, recuerda que aunno tenemos que hacer que funcione solo implementa las clases de modo que sea coherente con el diagrama

### Respuesta del Asistente:
* Se implementaron los archivos de modelo en el paquete `com.example.farmacia.model` aplicando principios de Programación Orientada a Objetos (Abstracción, Herencia, Encapsulación y Polimorfismo):
  1. `Identificable.kt`: Interfaz base para entidades con ID (Abstracción).
  2. `Categoria.kt`: Data class de categorías.
  3. `Producto.kt`: Encapsulación con validación de invariants (precio/stock no negativos) en `init` y propiedad calculada `disponible`.
  4. `Usuario.kt`: Clase abstracta `Usuario`, subclase `Cliente` y objeto de valor `Direccion` (Herencia).
  5. `RecetaMedica.kt`: Entidad de receta médica con enum `EstadoReceta`.
  6. `Carrito.kt`: Data class `CarritoItem` y clase `Carrito` con encapsulación de la lista interna mutable `_items` exponiendo operaciones inmutables.
  7. `Pedido.kt`: Modelo de pedido con reglas de negocio en `init` (validación de receta médica obligatoria si incluye medicamentos controlados) y enums `EstadoPedido` y `MetodoPago`.

---

## Prompt 3
> **Usuario:**
> Diseña dos interfaces grafica(no toques el codigo) que permitan listar al menos 2 de los objetos implementados, detallando que elementos del jetpack compose seran utilizados

### Respuesta del Asistente:
* Sin modificar código del proyecto, se diseñaron conceptualmente dos pantallas en el artefacto `diseno_interfaces_compose.artifact.md`:
  1. **`CatalogScreen`**:
     * **Objetos listados**: `Categoria` y `Producto`.
     * **Componentes Compose**: `Scaffold`, `CenterAlignedTopAppBar`, `BadgedBox` con `Badge`, `OutlinedTextField` (búsqueda), `LazyRow` con `FilterChip` (categorías), `LazyVerticalGrid` con `ElevatedCard` (productos), `AssistChip` (`requiereReceta`), `Text` y `Button`.
  2. **`CartScreen`**:
     * **Objetos listados**: `CarritoItem`, `Producto` y `Pedido`.
     * **Componentes Compose**: `Scaffold`, `TopAppBar`, `Card` de alerta (`errorContainer`), `LazyColumn` para `CarritoItem`, `OutlinedCard`, `Row`/`Column`, `IconButton` (`[+]`, `[-]`, `[🗑️]`), `HorizontalDivider`, `Surface` fijo inferior con Total y `Button` ("Proceder al Pago"), e `AlertDialog` modal para receta médica.

---

## Prompt 4
> **Usuario:**
> Ahora continuando contruye 2 pantallas utilizando jetpack compose que permita visualizar al menos 2 de los objetos implementados(Puedes usar los que ya usaste) y que estas interfaces puedan ser visibles

### Respuesta del Asistente:
* Se implementaron en código Kotlin con Jetpack Compose todas las pantallas y la infraestructura visual:
  1. `MockData.kt` (`com.example.farmacia.ui.data`): Colección de datos de prueba de categorías y productos farmacéuticos.
  2. `CatalogScreen.kt` (`com.example.farmacia.ui.screens`):
     * Filtro por categorías interactivo (`LazyRow` + `FilterChip`).
     * Grilla de productos (`LazyVerticalGrid` de 2 columnas) con etiquetas de receta médica y precios.
     * Barra de búsqueda reactiva por texto.
     * Contador en tiempo real en la barra superior.
  3. `CartScreen.kt` (`com.example.farmacia.ui.screens`):
     * Lista desglosada del carrito (`LazyColumn`) con controles para aumentar, reducir y eliminar productos.
     * Banner de advertencia en rojo si el pedido contiene medicamentos que requieren receta.
     * Barra inferior fija con cálculo automático del Total.
     * Diálogo emergente (`AlertDialog`) de validación de receta médica.
  4. `MainScreen.kt` (`com.example.farmacia.ui.screens`):
     * Contenedor principal con barra de navegación inferior (`NavigationBar`) que conecta las pestañas "Catálogo" y "Carrito".
  5. `MainActivity.kt`:
     * Punto de entrada principal configurado para ejecutar `MainScreen()`.

---

## Prompt 5
> **Usuario:**
> Ahora guarda la conversacion en un md llamao prompts.md

### Respuesta del Asistente:
* Se generó este archivo `prompts.md` en la raíz del proyecto registrando cronológicamente todas las solicitudes del usuario y las respuestas e implementaciones del asistente.
