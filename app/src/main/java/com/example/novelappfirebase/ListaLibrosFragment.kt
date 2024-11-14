package com.example.novelappfirebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.novelapp.Libro

class ListaLibrosFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_libros_fragment, container, false)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_libros)
        val adapter = LibroAdapter { libro ->
            sharedViewModel.selectLibro(libro)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        val libros = cargarLibros()
        adapter.submitList(libros)

        return view
    }

    private fun cargarLibros(): List<Libro> {
        return listOf()
    }
}
