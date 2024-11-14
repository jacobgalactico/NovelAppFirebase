package com.example.novelapp

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import java.util.UUID

class SyncJobService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        sincronizarConFirebase {
            jobFinished(params, false)
        }
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return true
    }

    private fun sincronizarConFirebase(onComplete: () -> Unit) {
        val db = FirebaseFirestore.getInstance()

        // Agregar instancias de libros con valores válidos para cada parámetro, incluyendo el 'id'
        val libros = listOf(
            Libro(
                id = UUID.randomUUID().toString(), // Genera un ID único
                titulo = "El Quijote",
                autor = "Miguel de Cervantes",
                anioPublicacion = 1605,
                sinopsis = "Una gran obra clásica",
                esFavorita = false
            ),
            Libro(
                id = UUID.randomUUID().toString(), // Genera un ID único
                titulo = "Cien años de soledad",
                autor = "Gabriel García Márquez",
                anioPublicacion = 1967,
                sinopsis = "La historia de la familia Buendía",
                esFavorita = false
            )
        )

        libros.forEach { libro ->
            val libroMap = hashMapOf(
                "titulo" to libro.titulo,
                "autor" to libro.autor,
                "anioPublicacion" to libro.anioPublicacion,
                "sinopsis" to libro.sinopsis,
                "esFavorita" to libro.esFavorita
            )
            db.collection("novelas").add(libroMap)
                .addOnSuccessListener { documentReference ->
                    Log.d("SyncJobService", "Documento agregado con ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("SyncJobService", "Error añadiendo documento", e)
                }
        }
        onComplete()
    }
}
