package com.example.NovelAppFirebase

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import com.example.novelapp.Libro
import java.util.UUID

@Composable
fun AgregarNovelaScreen(onAgregarNovela: (Libro) -> Unit) {
    var titulo by remember { mutableStateOf("") }
    var autor by remember { mutableStateOf("") }
    var anioPublicacion by remember { mutableStateOf("") }
    var sinopsis by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título") })
        TextField(value = autor, onValueChange = { autor = it }, label = { Text("Autor") })
        TextField(
            value = anioPublicacion,
            onValueChange = { anioPublicacion = it },
            label = { Text("Año de Publicación") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(value = sinopsis, onValueChange = { sinopsis = it }, label = { Text("Sinopsis") })

        Button(onClick = {
            if (titulo.isNotBlank() && autor.isNotBlank() && anioPublicacion.isNotBlank() && sinopsis.isNotBlank()) {
                val anio = anioPublicacion.toIntOrNull() ?: 0  // Convertir a Int o usar 0 si no es numérico
                val novela = Libro(
                    id = UUID.randomUUID().toString(), // Generar un ID único
                    titulo = titulo,
                    autor = autor,
                    anioPublicacion = anio,
                    sinopsis = sinopsis
                )
                onAgregarNovela(novela)
            }
        }) {
            Text("Agregar Novela")
        }
    }
}
