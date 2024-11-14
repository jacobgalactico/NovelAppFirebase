package com.example.novelappfirebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.novelapp.Libro

class DetallesLibroFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detalles_libro_fragment, container, false)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Observa el libro seleccionado
        sharedViewModel.selectedLibro.observe(viewLifecycleOwner) { libro ->
            libro?.let {
                mostrarDetalles(view, libro)
            }
        }

        return view
    }

    private fun mostrarDetalles(view: View, libro: Libro) {
        // Actualiza los elementos de la UI con los detalles del libro
        view.findViewById<TextView>(R.id.titulo).text = libro.titulo
        view.findViewById<TextView>(R.id.autor).text = libro.autor
        // Agrega más detalles según tus necesidades
    }
}
