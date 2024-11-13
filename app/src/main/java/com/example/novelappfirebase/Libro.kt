package com.example.novelapp

data class Libro(
    val id: String,               // ID único del libro
    val titulo: String,            // Título del libro
    val autor: String,             // Autor del libro
    val anioPublicacion: Int,      // Año de publicación
    val sinopsis: String,          // Breve descripción del libro
    var esFavorita: Boolean = false, // Indica si el libro es favorito o no
    val resenas: MutableList<String> = mutableListOf() // Reseñas del libro
)
