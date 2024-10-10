import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.novelapp.Libro
import com.google.firebase.firestore.FirebaseFirestore

class SyncAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("SyncAlarmReceiver", "Alarma recibida. Sincronizando datos...")

        sincronizarConFirebase()
    }

    private fun sincronizarConFirebase() {
        val db = FirebaseFirestore.getInstance()
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
                    Log.d("SyncAlarmReceiver", "Documento agregado con ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("SyncAlarmReceiver", "Error añadiendo documento", e)
                }
        }
    }
}
