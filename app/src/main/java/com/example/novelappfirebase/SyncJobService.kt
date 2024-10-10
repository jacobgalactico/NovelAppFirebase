package com.example.novelapp

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class SyncJobService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        // Aquí comienza la sincronización
        sincronizarConFirebase {
            jobFinished(params, false)
        }
        return true // El trabajo continúa ejecutándose en segundo plano
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        // Aquí puedes manejar la cancelación del trabajo si es necesario
        return true
    }

    private fun sincronizarConFirebase(onComplete: () -> Unit) {
        val db = FirebaseFirestore.getInstance()

        // Supongamos que tienes una colección llamada "novelas"
        val libros = listOf(
            Libro("El Quijote", "Miguel de Cervantes", 1605, "Una gran obra clásica"),
            Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "La historia de la familia Buendía")
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
        onComplete() // Llama a onComplete cuando termine
    }
}
