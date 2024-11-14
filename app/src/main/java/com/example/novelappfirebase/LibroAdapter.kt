package com.example.novelappfirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.novelapp.Libro

class LibroAdapter(private val onClick: (Libro) -> Unit) : ListAdapter<Libro, LibroAdapter.LibroViewHolder>(LibroDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_libro, parent, false)
        return LibroViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LibroViewHolder(itemView: View, val onClick: (Libro) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val tituloTextView: TextView = itemView.findViewById(R.id.titulo_libro)

        fun bind(libro: Libro) {
            tituloTextView.text = libro.titulo
            itemView.setOnClickListener { onClick(libro) }
        }
    }

    class LibroDiffCallback : DiffUtil.ItemCallback<Libro>() {
        override fun areItemsTheSame(oldItem: Libro, newItem: Libro) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Libro, newItem: Libro) = oldItem == newItem
    }
}
