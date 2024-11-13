package com.example.novelappfirebase

import java.util.UUID
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.novelappfirebase.ui.theme.NovelAppFirebaseTheme
import androidx.activity.compose.BackHandler
import com.example.novelapp.AgregarNovelaScreen
import com.example.novelapp.DetallesLibroScreen
import com.example.novelapp.Libro
import com.example.novelapp.ListaLibrosScreen

@Composable
fun App() {
    var pantallaActual by remember { mutableStateOf("lista") }
    var libroSeleccionado by remember { mutableStateOf<Libro?>(null) }

    // Lista de libros de ejemplo
    val listaLibros = remember {
        mutableStateListOf(
            Libro(
                id = UUID.randomUUID().toString(),
                titulo = "El Quijote",
                autor = "Miguel de Cervantes",
                anioPublicacion = 1605,
                sinopsis = "Una gran obra clásica"
            ),
            Libro(
                id = UUID.randomUUID().toString(),
                titulo = "Cien años de soledad",
                autor = "Gabriel García Márquez",
                anioPublicacion = 1967,
                sinopsis = "La historia de la familia Buendía"
            )
        )
    }

    NovelAppFirebaseTheme {
        when (pantallaActual) {
            "lista" -> ListaLibrosScreen(
                libros = listaLibros,
                onEliminarLibro = { listaLibros.remove(it) },
                onMarcarFavorito = { libro ->
                    val index = listaLibros.indexOf(libro)
                    listaLibros[index] = libro.copy(esFavorita = !libro.esFavorita)
                },
                onVerDetalles = {
                    libroSeleccionado = it
                    pantallaActual = "detalles"
                },
                onAgregarClick = { pantallaActual = "agregar" },
                modifier = Modifier.fillMaxSize()
            )
            "agregar" -> AgregarNovelaScreen(onAgregarNovela = { nuevaNovela ->
                listaLibros.add(
                    nuevaNovela.copy(id = UUID.randomUUID().toString())
                )
                pantallaActual = "lista"
            })
            "detalles" -> libroSeleccionado?.let { libro ->
                BackHandler {
                    pantallaActual = "lista"
                }

                DetallesLibroScreen(
                    libro = libro,
                    onMarcarFavorito = {
                        val index = listaLibros.indexOf(libro)
                        listaLibros[index] = libro.copy(esFavorita = !libro.esFavorita)
                    },
                    onAgregarResena = { resena ->
                        val index = listaLibros.indexOf(libro)
                        listaLibros[index].resenas.add(resena)
                    }
                )
            }
        }
    }
}
